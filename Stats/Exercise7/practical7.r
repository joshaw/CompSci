data <- read.csv ("driving.csv")

# We need to make two variables that we can use in the creation of graphs, descriptive statistics etc. We can do this using the subset() function

control <- subset (data$score, data$condition=="control")
text <- subset (data$score, data$condition=="text")

# Make a histogram showing the frequency distribution of the driving scores in both the control and text conditions
xx = c(0,8)
yy = c(0,10)
brks = seq(0,8,1)

pdf( height=11, width=8.5, file="graphs.pdf" )
par( omi=c( 1,1,1,1 ) )

hist (control, xlab="Driving Scores", main="Driving scores for texting (blue) and control (purple) conditions", xlim=xx, ylim=yy, breaks=brks, col=rgb(0,0,1,1/3))
hist (text, breaks=brks, col=rgb(0,1,1,1/3), add=T)

# Run boxplots to identify outliers and the general spread of the data. Use the boxplot() function to generate boxplots of both conditions on the same graph.
boxplot(data$score~data$condition, ylim= xx, ylab="Score", main="Control and Test Scores")

mysummary <- function(x) {
     v1 <- mean(x)
     v2 <- median(x)
     v3 <- var(x)
     v4 <- sd(x)
     v5 <- length(x)
     return(list( mean=v1, median=v2, var=v3, sd=v4, N=v5))
}

# Use the mysummary function (defined for you above) to get descriptive statistics for both conditions

mysummary (control)
mysummary (text)
# A good idea in presenting statistics in scientific reports is the inclusion of bar charts to show the means of the conditions graphically. Create a bar chart of the two means of the control and text conditions with error bars.
# hint: use barplot() function.

drive.mean <- c( mean(control), mean(text) )
drive.mean
drive.sd <- c( sd(control), sd(text) )

names(drive.mean) <- c("Control", "Text")

se.bar <- function(x, y, upper, lower=upper, length=0.1,...) {
    if(length(x) != length(y) | length(y) !=length(lower) | length(lower) != length(upper))
       stop("vectors must be same length")

    arrows(x,y+upper, x, y-lower, angle=90, code=3, length=length, ...)
}

br <- barplot (drive.mean, main = "Graph of Condition Means", xlab= "Secondary Driving Task", ylab="Driving Score", ylim=c(0,8))

se.bar( br, drive.mean, drive.sd/sqrt(length(control)))

## As we are conducting an independent samples t-test we need to identify 1) whether our data conforms to the assumption of normality and 2)homogeinity of variance before we perform a t-test on it. We can do this using Shapiro Wilk and Levene's tests. We want the tests to have a p value above 0.05  (p>0.05). This would mean that the distribution of the data is not significantly different from a normal distribution and that the variances are roughly equal.

shapiro.test (control)
shapiro.test (text)

library ('car')
leveneTest(data$score, data$condition)

# Run the t-test to identify whether there is a significant difference between the control and the text conditions
t.test (control,text, paired=F)

# You will see in the output that the degrees of freedom do not match what we'd expect from the lecture (i.e. N-2). This is because R runs a Welch's t-test that alters the degrees of freedom to take into account any deviations from homogeinity in the variances of the groups (which is tested by the Levene's test).

# Write the results of the t-test conforming to the reporting structure in the lecture using the degrees of freedom quoted by R in the t-test output.

# t(30) = 2.673, p=0.012
