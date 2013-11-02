facebook_data <- read.csv("facebook_data_final.csv", header=T)

FB <- facebook_data[facebook_data$Are_you_a_member_of_Facebook == "Y", ]
FB[is.na(FB)] <- 0

table_genders <- table(FB$Gender)
#table_genders

FB$bonding_3 <- 5 - FB$bonding_3
FB$bonding_9 <- 5 - FB$bonding_9

FB$facebook_int1 <- FB$facebook_int1+1
FB$facebook_int1 <- replace (FB$facebook_int1, FB$facebook_int1==2, 1.5)
FB$facebook_int1 <- replace (FB$facebook_int1, FB$facebook_int1==3, 2)
FB$facebook_int1 <- replace (FB$facebook_int1, FB$facebook_int1==4, 2.5)
FB$facebook_int1 <- replace (FB$facebook_int1, FB$facebook_int1==5, 3)
FB$facebook_int1 <- replace (FB$facebook_int1, FB$facebook_int1==6, 3.5)
FB$facebook_int1 <- replace (FB$facebook_int1, FB$facebook_int1==7, 4)
FB$facebook_int1 <- replace (FB$facebook_int1, FB$facebook_int1==8, 4.5)
FB$facebook_int1 <- replace (FB$facebook_int1, FB$facebook_int1==9, 5)

FB$facebook_int2 <- FB$facebook_int2+1
FB$facebook_int2 <- replace (FB$facebook_int1, FB$facebook_int1==2, 1.8)
FB$facebook_int2 <- replace (FB$facebook_int1, FB$facebook_int1==3, 2.6)
FB$facebook_int2 <- replace (FB$facebook_int1, FB$facebook_int1==4, 3.4)
FB$facebook_int2 <- replace (FB$facebook_int1, FB$facebook_int1==5, 5.2)
FB$facebook_int2 <- replace (FB$facebook_int1, FB$facebook_int1==6, 5)

mean_intensity <- rowMeans (FB[, 4:11])
mean_bonding <- rowMeans (FB[, 12:21])
mean_bridging <- rowMeans (FB[, 22:31])

statistics <- function(x)
{
    Mean <- mean(x)
    Median <- median(x)
    Varience <- var(x)
    SD <- sd(x)
    Length <- length(x)
    return(list(mean=Mean, median=Median, var=Varience, sd=SD, N=Length))
}

pdf( height=11, width=8.5, file="graphs.pdf" )
par( omi=c( 1,1,1,1 ) )

hist(mean_intensity)
hist(mean_bonding)
hist(mean_bridging)
boxplot(mean_intensity, mean_bonding, mean_bridging)

shapiro.test(mean_intensity)
shapiro.test(mean_bonding)
shapiro.test(mean_bridging)

plot(mean_intensity, type="b")
plot(mean_bonding, type="b")
plot(mean_bridging, type="b")
