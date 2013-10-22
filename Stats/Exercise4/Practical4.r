N <- 90
z  <- rnorm(N, mean=0, sd=15)
examscore <- z + 62 + rnorm (N, mean=0, sd=7)
friends <- -z + 200 + rnorm(N, mean=0, sd=10)

plot(examscore, friends)

# Mean - examscore

stdev <- function(data){
	stdev <- sum((data - mean(data))^2) / (length(data) -1)
	return(stdev)
}

results <- stdev(examscore)

results

var(examscore)
