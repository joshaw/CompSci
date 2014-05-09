n <- 10000

# Make x a vector of "n" random numbers between "min" and "max"
x <- runif( n, min=1, max=10 )

# Write a histogram of those random numbers. Since they are random, the
# histogram should be uniformly distributed - flat.
hist( x )

# Size of the array M, ie how many peices of data are used - the more that are
# used, the more like a normal distribution the data will appear.
N <- 1200

# Initialise M with N spaces filled with nothing.
M <- rep(NA,N)

for( i in 1:N ) {
	# Fill X with a sample of size 100 from the random numbers in x
	X <- sample( x, 100 )
	# Add the mean of this sample to the array M
	M[i] <- mean(X)
}

M

# Plot a histogram of the data in M
hist( M )
