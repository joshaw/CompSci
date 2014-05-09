---
layout: default
title: Evaluation Methods and Statistics
---

#Evaluation Methods and Statistics

* * *
* TOC
{:toc}
* * *

## Data Types

1. ### Categorical
	1. Nominal Data
		- Data ascribing objects or values to distinct catagories
		- eg names, identifiers, high, low
	1. Ordinal Data
		- Data that can be ordered
		- eg a person's favourite ice creams.

1. ### Continuous
	1. Interval Data
		- Like ordinal, but with the addition that we know the size of the gaps 
	  	  betweeen points on the scale
	1. Ratio Data
		- Like interval, but the scale has a zero point
		- eg reaction times.

## Variables
- **Idependant** variables define the conditions of the experiment.
- **Dependant** variables are what is measured in the experiment.
	- They are *dependant* on the conditions of the experiment and are so 
	  interesting enough to be measured.
	- Two types of DV variation
		1. Unsystematic
			- Differences due to unknown (or unmeasured) factors
			- eg change in room environment from condition 1 to 2, personality
		1. Systematic
			- Differences due to the change in IV
			- Interesting in measuring.

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
- **H0 is falsifiable.** It is the *null hypothesis*.

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

#### Central Limit Theorem
- Distribution of means that would be expected if the sample size was infinite 
  and the mean was calculated for each sample.

> As `N` increases, the shape of the sampling distribution approaches normal, 
> whatever the shape of the parent population.

- If the population is normal, the sampling distribution of the mean will be 
  exactly normal regardless of the sample size.

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
	- sum( (y- mean(y))² )
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
- Requires two continuous variables
- Gives no information on causation
- *Co-vary*
	- If the scores for one variable change, the scores for the other variable 
	  will chane in a predictable way.
	- Means that the variables are not independent.

### Pearson's r

#### Co-Variance
- `sum`((x - `mean`(x))(y - `mean`(y))) / (N-1)

#### Pearson's r
- Measure of correlation that does not increase with the variance.
- r = `cov`(x,y) / Sx Sy
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

## Errors
- **Type 1 Error**
	- False positive
		- When we beleive there is a genuine effect but really there isn't.
- **Type 2 Error**
	- False negative
		- When be beleive there is no effect, but really there is.
		- Lot of variation between samples
		- Too stringent controls for type 1 errors
		- Low power statistics to find effects.
- **Family-wise Error rate**
	- Rate of errors when using multiple tests (a family of tests)
	- Ex
		- We have 3 tests in the family of tests
		- Fisher's level of 0.05 as the level of significance
		- Probability of false positive (type 1 error) in all these tests is 
		  0.95×0.95×0.95 = 0.875
		- So probability of type 1 error is 1-0.857 = 0.143
	- This is far greater than the error rate for each test individually.
	- Use a different test to remove the increased probability of type 1 errors 
	  (ANOVA).
		
## Regression
- Significance of a predictor variable on an outcome variable
- Requires two (or more) continuous variables
- Allows the future values of the outcome to be predicted based on the known 
  current value of the predictor.
- Predictor can be continuous or categorical.

### Regression Modelling

#### Best Fit
- Draw the line that seems to fit the majority of the data.
- Very subjective
	- Can not be sure if this is actually the best fit

#### Method of Least Squares
- Residual difference between the line and the actual data point
- The line of best fit (*regression line*) is the line that leads to minimum 
  residual
- The residuals are summed and squared as some will be negative and some 
  positive.
	- Might be the best line to describe the data, but might still be a poor 
	  description of the data.
	- Need to know how well the suggested model fits the data.
	- Compare to most basic model (mean) using *Sum of Squares*.

#### Total Sum of Squares (SST)
- SST = `sum`( y<sub>i</sub> - `mean`(y) )²
- Total amount of difference present when the simplest model is applied.

#### Residual Sum of Squares (SSR)
- SSR = `sum`( y<sub>i</sub> - y<sub>model</sub> )²
- Total amount of differences present with best fit model.

#### Model Sum of Squares (SSM)
- SSM = `sum`( y<sub>model</sub> - `mean`(y) )²
- Total amount of difference between the predicted y from the best fit and the 
  mean of y.
- Alternatively
	- SSM = SST - SSR

### Evaluating the Model
- If SSM is large, the model has made big improvements of just using the mean.
- If SSM is small then the model has made little improvement over the mean.
- **R²** shows how much improvement has been made:
	- R² = SSM / SST
	- How much variation explained by the model as a proportion of how much 
	  there was in the first place.
	- R² &times; 100 = percentage of variation explained by the model.
- Can also evaluate the success of the model using F-ratio test.

## Statistical Tests

### Correlation Test
- Two continuous variables
- Reported as 
	- r(`degrees of freedom`) = `coefficient`, p< `P-value`
	- eg r(82)=-0.79, p<0.001

### Regression Test
- Two (or more) continuous variables
- Allows prediction of variable based on the value of others

### Levene's Test
- Tests for homogeneity of variances
- Null hypothesis is that the variences are equal.
- Want it to be big
	- Says that there is no difference between the variances in the population.

### T-Test
- Most basic form of statistical test
- Causal inference
- *Requires* 1 continuous variable and 1 catagorical variable with 2 levels
- If the sample mean difference is larger than we expect
	- We have collected two samples by chance that are atypical of the 
	  population, **or**
	- The two samples are from different populations.
- Between participants: independant t-test
- Within participants: dependant t-test

#### Standard T-Test
- Between Subjects
- Independent means t-test
- Used when there are exactly 2 groups to be tested
	- eg control group vs experimental group
- Are two sets of data significantly different from one another?

#### Paired T-Test
- Within Subjects
- Dependant means t-test
- Compares the actual difference between two means in relation to the variation 
  in the data
	- Expressed as the standard deviation of the difference between the mean.
- Can only compare two groups at a time
- Bad practice to use multiple times for a single experiment.
- Used for "Before vs. After" experiments where the *same* individuals are 
  measured before and after the application of some sort of treatment.
- Also used for "Left vs. Right" experiments where two sides of an individual 
  are given two different treatments.

### ANOVA
- Use instead of multiple t-tests (remove family-wise errors)
- Assumes
	- Normally distributed data
	- Equality of variance
	- Interval or ratio data
	- Independent data.
- Reported as
	- `f(dof_m,dof_r) = f-ratio, p < p-value`
	- `dof_m` = degrees of freedom of the levels
		- K-1 (number of levels - 1)
	- `dof_r` = degrees of freedom
		- N-K (number of participants - number of levels)

#### One-Way ANOVA
- Similar to a t-test
- Used to compare the means from *three or more* groups
- *Requires* 1 continuous variable and 1 catagorical variable with 2 or more 
  levels.

#### Two-Way ANOVA
- Compare means of *two or more* groups in response to *two different 
  independant variables*.
- Allows an experiment which where participants are exposed to a varying level 
  of two different treatments.
- *Requires* 1 continuous variable and 2 catagorical variables.
  
  |--
  | Type    | ANOVA Used              |
  | ------- | ----------
  | Between | Two way Unrelated ANOVA |
  | Within  | Two way Related ANOVA   |
  | Mixed   | Two way Mixed ANOVA     |

### Linear Regression
- Comparing the means of groups along a continuum of *three or more* treatment 
  levels.
- Can also be used for three or more treatments set at regular intervals
- Provides a graph with a line of best fit that passes as close as possible to 
  all the data points.

### Shapiro-Wilk
- Is the data normally distributed?
- Compares sample distribution to normal distribution
- If the sample is significantly different to the normal distribution, then 
  test will be statistically significant.
- Want it to be **non-significant**
	- p > 0.05

### Levene's Test
- Equality of Variance.
	- Variance in populations is roughly equal
	- Homogeneity of Variance

### Mauchly's Test of Sphericity
- Test the hypothesis that the variances of the differences are equal (H0)
- Want it to be **non-significant**
	- p > 0.05
	- States that there is a significant difference between variance of 
	  differences.

### Post Hoc Test
- Used when we have no specific a priori predictions about the data.
- Exploratory data analysis
- Pairwise comparisons
	- Like performing t-tests on all the pairs of means in the data
- eg LSD (Lest Significant Differences)
- eg Bonferroni
	- How would you correct for type 1 errors? Bonferroni
- eg Tukey's Test

### F-Ratio
- Variation **explained** by our model / Variation **unexplained** by our model
- Mean square model / Mean square residual
	- MS<sub>M</sub> / MS<sub>R</sub>

## Experiments

### Types of Experiment
- **Between Subjects**
	- Two or more groups of participants
	- Each participant takes part in one of the conditions.
	- No-one does both conditions
	- Reduces error rates from effects such as people learning how to perform 
	  better from the first condition.
	- Also used when the same participant cannot take place in both conditions
		- eg "Effect of single gender schooling"
	- Controlled with *sample matching*
		- Match the sample of participants in the two groups so that there is 
		  no bias towards one or the other group.
- **Within Subjects**
	- Single group of participants
	- Each member of the group takes part in all of the conditions of the 
	  experiment
	- Used when taking part in one condition is likely to have little or no 
	  effect on the results of others
		- eg "Effect of secondary task on driving"
	- Controlled with *counterbalancing*
		- If there is a small chance, or small effect, from learning or bordem 
		  etc. through the duration of the experiement, some of the 
		  participants can perform the experiments in reverse order to reduce 
		  the effect.
			- Some perform Case1 then Case2, others Case2 then Case1.
		- Practice effects
		- Boredem effects

### Stroop

### Fitt's Law

### Secondary Test While Driving

## Scientific Process
1. Generate a hypothesis
1. Design experiment/study to test the hypothesis
1. Collect data from sample
1. Fit statistical model to the data
1. Assess how well this model represents the data (the model fit).

- H0 given more weight
	- Experiment run to disprove H0
		- Do not reject it unless there is sufficiently strong evidence to do 
		  so.
		- Discount the simple before adopting something more complex
			- Occam's Razor.
- Claim, Data, Qualification, Warrant
	- Claim
		- What is it that is being suggesting.
	- Data
		- What information is availible to back this up.
	- Qualification
		- What degree of certainty is there.
	- Warrant
		- Interprets the data and shows how it supports the claim.

### Ethics
- Do not be complacent
- Academics employed by a university are obliged to consult an ethics 
  committee.
- Marketers and private individuals are not obliged.

#### Deception
- Participants should not, where possible, be deceived.
- If a participant knows the desired outcome of the experiment, they are likely 
  to change their behaviour to match it.
	- This can affect the validity of the results of the experiment.
	- Build an ethical reason for deceiving someone.
- Participants should not stay deceived.
	- Debrief to explain the experiment, motivations, conditions they took part 
	  in, contact details for further information.

#### Social Capital
> The good will that is engendered by the fabric of social relations and that 
> can be mobilized to facilitate action.

- *Briding Social Capital*
	- "Weak ties"
	- Typically do not provide emotional support
- *Bonding Social Capital*
	- Between individuals in tightly-knit relationships
		- eg family and close friends
	- Highly trusting relationships

## Case Studies
- Stroop
	- T-test
- Twitter Posts - Anxiety 
	- Regression
- Social Capital - Facebook
- Secondary test while driving
	- Post hoc tests
	- T-test
	- Shapiro-Wilk
	- Levene's Test
	- F-ratio
	- 1-way ANOVA
	- 2-way ANOVA
	- Mauchly's Test for Sphericity
- Fitt's Law (assessment)
	- Shapiro-Wilks
	- T-test
- Little Albert
	- Ethics

## Basic R Commands

~~~
> seq(1,5)
> 1:10
[1] 1 2 3 4 5

> rep(1,5)
[1] 1 1 1 1 1

Assignment
> a<-b

Concatenation
> c(a, b)
> c(1:10,rep(1,4))

Vector index
> d
[1] 1 2 3 4 5 6 7 8
> d[3]
3
> d[2:4]
[1] 2 3 4
> d<6
[1] TRUE TRUE TRUE TRUE TRUE FALSE FALSE FALSE
> d[d<6]
[1] 1 2 3 4 5

Sort vectors
> sort()

Sample randomly
> sample(1:46,6)

Simulate samples from probability
> rnorm(5, mean=3, sd=1)
[1] 1.704127 3.636264 4.137285 4.825439 3.034183

Round numbers
> round()

Common stats functions
> mean(x)
> length(x)
> median(x)
> sd(x)
> var(x)
> sum(x)
> summary(x)
   Min. 1st Qu.  Median    Mean 3rd Qu.    Max.
  27.00   43.75   53.00   51.65   60.00   71.00

Functions
> my.plot <- function( n ) {
+   x <- rnorm( n, mean=10, sd=1 )
+   plot(hist(x), add=TRUE)
+ }
> my.plot(10)
> my.plot(50)
> my.plot(100)
> my.plot(1000)

Read data
> x <- scan("data.dat")

Read tabular data
> mytab<-read.table("mytable.txt",header=TRUE)
> mytab
   Name Shoe.size Height
1  Fred         9    170
2   Jim        10    180
3  Bill         9    185
4  Jane         7    175
5  Jill         6    170
6 Janet         8    180

Write data
> write(x, "ouput.dat")

Access columns
> mytab$Height
> mytab[,3]
[1] 170 180 185 175 170 180

Access Rows
> mytab[4,]
4 Jane 7 175
> mytab[5,3]
[1] 170

Conditions
> mytab[mytab$Name=="Jane"]
4 Jane 7 175

Levene's Test
> levene.test()

~~~

<!--
Created:  Wed 09 Apr 2014 10:04 am
Modified: Fri 09 May 2014 07:19 PM
-->
