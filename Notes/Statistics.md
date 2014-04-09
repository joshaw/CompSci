---
layout: default
title: Evaluation Methods and Statistics
---

#Evalutation Methods and Statistics

* * *
* TOC
{:toc}
* * *

## Data Types
- Catagorical Data
	- eg names, identifiers
- Ordinal Data
	- Data that can be ordered
	- eg a person's favourite ice creams.
- Interval
	- Like ordinal, but with the addition that we know the size of the gaps 
	  betweeen points on the scale
- Ratio
	- Like interval, but the scale has a zero point
	- eg reaction times.

## Variables
- **Idependant** variables define the conditions of the experiment.
- **Dependant** variables are what is measured in the experiment.
	- They are *dependant* on the conditions of the experiment and are so 
	  interesting enough to be measured.

### Randomisation
- Without randomisation, bias is introduced to the sample.
	- The selection of samples, candidates and participants must be outside the 
	  experimenter's hands.
- Bias reduces the validity with which the sample represents the population.
- Full randomisation from a global population is difficult (or impossible) to 
  achieve.
	- There are accepted limits on randomisation.

## Significance
- Significance tests allow us to test hypotheses
- A good hypothesis is falsifiable.
	- Which of these is falsifiable?
		- H0: There are no vultures on the UoB campus.
		- H1: There are vultures on the UoB campus.
	- H0 is falsifiable since we can check the campus and if we find a vulture, 
	  then the statement is immediately false. However, to falsify the claim 
	  that there are vultures requires us to check all of campus, so is much 
	  less feasible.

### Evidence of Absence
- Absence of evidence is not evidence of absence.
- We can look for vultures all day and fail to find them, but this does not 
  allow us to reject H1 because all we have is an absence of evidence.
- H0 is fundamentally different. We can reject H0 as soon as we see a vulture 
  in the campus.
- **H0 is falsifiable. It is the *null hypothesis* **.

### Null Hypothesis
- The significance of a test tells us if it reasonable to reject the null 
  hypothesis.
- The null hypothesis says that *nothing happened*.
	- eg Comparing samples in an experiment, the null hypothesis is that they 
	  are going to be the same.
	- eg When testing whether there is a correlation between two variables, the 
	  null hypotyhesis is that there is no correlation.
- The null hypothesis must be *falsifiable*.
- The null hypotheses is rejected when it can be said that it is sufficiently 
  unlikely.
	- eg The probability of the null hypothesis happening is less than 0.001, 
	  ie p < 0.001, so the null hypotheses can be rejected.

## Variability
- Everything varies
- Range is a simple method of measuring variability but it does not take into 
  account any grouping of data.
	- eg normal distribution.

#### Degrees of Freedom
- In general degrees of freedom is
	- The number of data points minus the number of parameters that went into 
	  the calculation.
- For the calculation of variance, the number of parameters is 1.
- So the degrees of freedom when calculating the variance is N-1.

### Methods

- Range
- Sum of differences
	- sum(y - mean(y))
	- But this gives zero when the differences cancel each other out
- Sum of squares
	- Sum of absolute differences.
	- sum( (y- mean(y))^2 )
	- Increases as the variability increases (good) but also as the amount of 
	  data increases.
- Variance

### Variance (s²)
- Sum of squares divided by the degrees of freedom to prevent additional data 
  increasing the value.
- **Standard Deviation** is the square root of the variance.

### Correlation (r)
- A measure of the relationship between variables
- Pearson's r as a quantitative measure of correlation
- *Co-vary*
	- If the scores for one variable change, the scores for the other variable 
	  will chane in a predictable way.
	- Means that the variables are not independent.

### Pearson's r

#### Co-Variance
- sum((x - mean(x))(y - mean(y))) / (N-1)

#### Pearson's r
- Measure of correlation that does not increase with the variance.
- r = cov(x,y) / Sx Sy
- Polarity (- or +)
	- whether the relationship is positive or negative
- Coefficient
	- strength of the relationship
- *Assumes*
	- Continuous variables
	- Pearson's r is a parametric test and it demands normal distributions of 
	  data.
	- Linear relationship.

### Significance (p)
- how significant is a correlation?
- is the value of r reliable?
- can we reject the hypotheses that there is no correlation?
