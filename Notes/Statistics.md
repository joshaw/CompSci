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

## Regression
- Significance of a predictor variable on an outcome variable
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
- Reported as 
	- r(`degrees of freedom`) = `coefficient`, p< `P-value`
	- eg r(82)=-0.79, p<0.001
	
### T-Test
- Most basic form of statistical test
- If the sample mean difference is larger than we expect
	- We have collected two samples by chance that are atypical of the 
	  population, **or**
	- The two samples are from different populations.

#### Standard T-Test
- Between Subjects
- Independant means t-test
- Used when there are exactly 2 groupt to be tested
	- eg. control group vs. expermimental group
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
  measured before and after the application of some sort of treatmnent.
- Also used for "Left vs. Right" experiments where two sides of an individual 
  are given two different treatments.

### ANOVA
- Assumes
	- Normally distributed data
	- Equality of variance
	- Interval or ratio data
	- Independant data.

#### One-Way ANOVA
- Similar to a t-test
- Used to compare the means from *three or more* groups

#### Two-Way ANOVA
- Compare means of *two or more* groups in response to *two different 
  independant variables*.
- Allows an experiment which where participants are exposed to a varying level 
  of two different treatments.

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
	- Variance in populations is rougly equal
	- Homogeinity of Variance

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
- eg LSD (Lest Significat Differences)
- eg Bonferroni
- eg Tukey's Test

### F-Ratio
- Variation **explained** by our model / Variation **unexplained** by our model
- Mean square model / Mean square residual
	- MS<sub>M</sub> / MS<sub>R</sub>

## Experiments

### Stroop

### Fitt's Law

### Secondary Tast While Driving

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
	- Lavene's Test
	- F-ratio
	- 1-way ANOVA
	- 2-way ANOVA
	- Mauchly's Test for Sphericity
- Fitt's Law (assessment)
	- Shapiro-Wilks
	- T-test
- Little Albert
	- Ethics

# TODO
 - Central limit theorem

<!--
Created:  Wed 9 Apr 2014 10:04:50 am
Modified: Sat 19 Apr 2014 12:11 pm
-->
