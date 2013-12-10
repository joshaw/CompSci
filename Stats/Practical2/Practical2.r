data <- read.csv("stats_fitts.csv")
data

pdf( height=11, width=8.5, file="graphs.pdf" )
par( omi=c( 0.5,0.5,0.5,0.5 ) )

plot (data$ID, data$W1, ylim=c(0, 650))
points (data$ID, data$W5, col="red")
abline(lm(data$W1~data$ID), col="black")
abline(lm(data$W5~data$ID), col="red")

t.test(data$W1, data$W5, paired=T)

################################################################################
data <- read.csv ("stats_fitts.csv")

# Make a histogram showing the frequency distribution of the driving scores in
# both the control and text conditions
xx = c(150,700)
yy = c(0,7)
brks = seq(0,8,1)

hist (data$W1, xlab="Time to Reach Target", main="Fick's Law", xlim=xx, ylim=yy, col=rgb(0,0,1,1/3))
hist (data$W5, col=rgb(0,1,1,1/3), add=T)

# Run boxplots to identify outliers and the general spread of the data. Use the
# boxplot() function to generate boxplots of both conditions on the same graph.
boxplot(data$W1, ylim= xx, ylab="Time", main="Wide and Narrow")
boxplot(data$W5, add=TRUE)

################################################################################
drive.mean <- c( mean(data$W1), mean(data$W5) )
drive.sd <- c( sd(data$W1), sd(data$W5) )

names(drive.mean) <- c("Wide", "Narrow")

se.bar <- function(x, y, upper, lower=upper, length=0.1,...) {
    if(length(x) != length(y) | length(y) !=length(lower) | length(lower) != length(upper))
       stop("vectors must be same length")

    arrows(x,y+upper, x, y-lower, angle=90, code=3, length=length, ...)
}

br <- barplot (drive.mean, main = "Graph of Condition Means", xlab= "Secondary Driving Task", ylab="Time to Reach Target", ylim=c(0,600))
se.bar( br, drive.mean, drive.sd/sqrt(length(data$W1)))

mysummary <- function(x) {
     v1 <- mean(x)
     v2 <- median(x)
     v3 <- var(x)
     v4 <- sd(x)
     v5 <- length(x)
     return(list( mean=v1, median=v2, var=v3, sd=v4, N=v5))
}

# Use the mysummary function (defined for you above) to get descriptive
#statistics for both conditions

cat("W1-------------\n")
mysummary (data$W1)

cat("W5-------------\n")
mysummary (data$W5)

# As we are conducting an independent samples t-test we need to identify
# homogeinity of variance before we perform a t-test on it. We can do this
# using Shapiro Wilk. We want the tests to have a p value above 0.05  (p>0.05).
# This would mean that the distribution of the data is not significantly
# different from a normal distribution and that the variances are roughly
# equal.
#
shapiro.test (data$W1)
shapiro.test (data$W5)
#
# Run the t-test to identify whether there is a significant difference between
# the control and the text conditions
t.test (data$W1,data$W1, paired=F)

# You will see in the output that the degrees of freedom do not match what we'd
# expect from the lecture (i.e. N-2). This is because R runs a Welch's t-test
# that alters the degrees of freedom to take into account any deviations from
# homogeinity in the variances of the groups (which is tested by the Levene's
# test).

# Write the results of the t-test conforming to the reporting structure in the
# lecture using the degrees of freedom quoted by R in the t-test output.

# t(27) = 10.9342, p<0.001
