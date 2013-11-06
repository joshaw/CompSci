data<- read.csv ("data.csv", header=T)

#  Recreate the graphs from the lecture. First the scatterplot with the mean line, then the regression line graph, then the graph with both the mean line and the regression line plotted.

pdf( height=11, width=8.5, file="graphs.pdf" )
par( omi=c( 0.5,0.5,0.5,0.5 ) )

plot (data$anxiety, data$posts)
abline(lm(data$posts~ data$anxiety), col="red")
abline(h=mean((data$posts)))

# Using R, calculate the correlation coefficient for the variables (see exercise on correlation if you are stuck on this).

correlation <- cor.test(data$posts, data$anxiety)
correlation

# Run the regression model on the data

model <- lm (data$posts ~data$anxiety)
summary (model)

# What percentange of the variance in posts is accounted for by the model?


# What percentange of the variance in posts is not accounted for by the model?


# What is the p value for this model?



# Is anxiety a statistically significant predictor? What is the p value for anxiety as a predictor?



# Write the straight line equation of this linear regression model
# hint: posts =      anxiety +
