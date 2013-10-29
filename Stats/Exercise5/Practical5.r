facebook_data <- read.csv("facebook_data_final.csv", header=T)

FB <- facebook_data[!facebook_data$id == "10"]

mean_age <- mean(FB$Age)
sd_age <- sd(FB$Age)

table_genders <- table(FB$Gender)

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

x[] <- FB[, FB$facebook_int_1:FB$facebook_int_8, 0:44]
rowmeans_facebook[] <- rowMeans (x)

rowmeans_facebook
