data <- read.csv ("driving.csv")
data

# Make 3 variables that we can use in the tests of normality below as well as
# in the creation of graphs, descriptive statistics etc. We can do this using
# the subset function
control <- subset (data$score, data$condition=="control")
text <- subset (data$score, data$condition=="text")
talk <- subset (data$score, data$condition=="talk")

# Make a histogram showing the frequency distribution of the driving scores in
# control, text and talk conditions
pdf( height=11, width=8.5, file="graphs.pdf" )
par( omi=c( 0.5,0.5,0.5,0.5 ) )

xx = c(0,8)
yy = c(0,10)
brks = seq(0,8,1)

hist (control, xlab="Driving Scores", main="Driving scores for texting (blue), talking (pink) \nand control (purple) conditions", xlim=xx, ylim=yy, breaks=brks, col=rgb(0,0,1,1/3))
hist (text, breaks=brks, col=rgb(0,1,1,1/3), add=T)
hist (talk, breaks=brks, col=rgb(1,0,1,1/3), add=T)

# Draw boxplots of the conditions on the same graph to identify outliers
boxplot (data$score~data$condition, ylab= ("Driving Score"), ylim= c(0,10))

# Gather some descriptive statistics (means, sd) for the conditions
mysummary <- function(x){
     v1 <- mean(x)
     v2 <- median(x)
     v3 <- var(x)
     v4 <- sd(x)
     v5 <- length(x)
     return(list( mean=v1, median=v2, var=v3, sd=v4, N=v5))
}

mysummary (control)
mysummary (text)
mysummary (talk)

# Create a bar graph with error bars showing the condition means for the data
drive.mean <- c( mean(control), mean(text), mean (talk) )
drive.sd <- c( sd(control), sd(text), sd(talk) )
names(drive.mean) <- c("Control", "Text", "Talk")

sd.bar <- function(x, y, upper, lower=upper, length=0.1,...) {
    if(length(x) != length(y) | length(y) !=length(lower) | length(lower) != length(upper))
       	stop("vectors must be same length")

    		arrows(x,y+upper, x, y-lower, angle=90, code=3, length=length, ...)
}
br <- barplot (drive.mean , main = "Graph of Condition Means", xlab= "Secondary Driving Task", ylab="Driving Score", ylim=c(0,8))

sd.bar( br, drive.mean, drive.sd/sqrt(length(control)))

# Test the assumptions of One Way independent ANOVA- normal distribution (using
# the shapiro.test() function) and equality of variance (leveneTest() function-
# You have to install and load the libraries for the car package for the
# levenes test),
# This is commented out as the package has been installed for you on the system
# install.package ("car")
library ('car')
leveneTest(data$score, data$condition, center=median)
shapiro.test (control)
shapiro.test (text)
shapiro.test (talk)

# Run the ANOVA using the aov() function. Get the output using the summary()
# function
model <- aov(score~condition, data=data)
summary(model)

# Use post hoc comparisons to compare the levels of the independent variable to
# find out where the significant difference between conditions are
pairwise.t.test (data$score, data$condition, paired=FALSE, p.adjust.method="bonferroni")

# Report the ANOVA using the reporting convention shown in the lecture as well
# as the results of the comparisons between conditions on driving score from
# the post hoc tests
# F(2, 45)= 27.25, p < 0.05
# there was a statistically significant difference between control and text
# (p=1.6e-6) as well as the control and talk conditions on driving ability
# (p=5.5e-8).
