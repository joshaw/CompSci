data <- read.csv("stats_fitts.csv")
data

pdf( height=11, width=8.5, file="graphs.pdf" )
par( omi=c( 0.5,0.5,0.5,0.5 ) )

plot (data$ID, data$W1, ylim=c(0, 650))
points (data$ID, data$W5, col="red")

t.test(data$W1, data$W5, paired=F)
t.test(data$W1, data$W5, paired=T)
