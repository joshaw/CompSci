n <- 100000000000

x <- runif( n, min=350, max=1200 )

hist( x )

N <- 120

M <- rep(NA,N)

for( i in 1:N ) {
X <- sample( x, 100 )
M[i] <- mean(X)
}

M

hist( M )
