# Emma Horsfield and Randy Truong worked together.

insertion.sort = function(x) {
  for (j in 2:length(x)) {
    key = x[j] 
    i = j - 1 
    while (i > 0 && x[i] > key) {
      x[(i + 1)] = x[i]
      i = i - 1 
    }
    x[(i + 1)] = key
  }
  return(x)
} 

selection.sort = function(x) {
  lenx <- length(x)
  for(i in seq_along(x))
  {
    mini = (i - 1) + which.min(x[i:lenx])
    start_ = seq_len(i-1)
    x <- c(x[start_], x[mini], x[-c(start_, mini)])
  }
  return(x)
}

quick.sort = function(x) {
  mid = sample(x, 1)
  left = c()
  right = c()
  
  lapply(x[x != mid], function(d) {
    if (d < mid) {left <<- c(left, d) } 
    else { right <<- c(right, d) }
  })
  
  if (length(left) > 1) { left = quick.sort(left) }
  if (length(right) > 1) { right = quick.sort(right) }
  return(c(left, mid, right))
}



##############################
### VECTOR SORTER FUNCTION ###
##############################

sort.time = function(size, times.each, sorting.method) {
  # Creates a vector from 1 to the given 'size' parameter, and chooses 'size' # of elements 
  # where vector element 'x' is 1<=x<=size
  random.vector = sample(1:size)
  
  # Sorts the previous 'random.vector' variable according to a given parameter:
  # three sorting methods: insertion, selection, and quick sort
  # in each, the System time is recorded, then the 'random.vector' variable is sorted
  # 'times.each' number of times for better precision.
  a = Sys.time()
  replicate(n=times.each,expr=sorting.method(random.vector))
  b = Sys.time()
  return(b-a)
  
  
}
### END OF FUNCTION ###

# Creates a sample containing 10 different sorting times from sorting a vector of
# size 10 elements 100 times through each sorting methods.

##### Comment out the current samples, and uncomment the ones with predetermined values #####
insertion.sample = replicate(10,sort.time(10,100,insertion.sort))
# Insertion:  0.0008418560 0.0011410713 0.0010430813 0.0012609959 0.0010240078 0.0010559559 0.0009601116 0.0009241104 0.0009930134 0.0016081333
# insertion.sample = c(0.0008418560, 0.0011410713, 0.0010430813, 0.0012609959, 0.0010240078, 0.0010559559, 0.0009601116, 0.0009241104, 0.0009930134, 0.0016081333)
selection.sample = replicate(10,sort.time(10,100,selection.sort))
# Selection: 0.007564068 0.002960920 0.002545118 0.002220154 0.002911806 0.002626896 0.002561092 0.002641916 0.002132177 0.002602816
# selection.sample = c(0.007564068, 0.002960920, 0.002545118, 0.002220154, 0.002911806, 0.002626896, 0.002561092, 0.002641916, 0.002132177, 0.002602816)
quick.sample = replicate(10,sort.time(10,100,quick.sort))
# Quick: 0.009315014 0.010612965 0.010421038 0.006756067 0.008133173 0.012464046 0.007443190 0.013081074 0.010808945 0.007689953
# quick.sample = c(0.009315014, 0.010612965, 0.010421038, 0.006756067, 0.008133173, 0.012464046, 0.007443190, 0.013081074, 0.010808945, 0.007689953)



################################
### OUTLIER REMOVER FUNCTION ###
################################

remove.outliers = function(data) {
  # outlier test: Q1 - 1.5IQR
  lower.bound = quantile(data,0.25) - 1.5*IQR(data)
  
  # outlier test: Q3 + 1.5IQR
  upper.bound = quantile(data,0.75) + 1.5*IQR(data)
  
  # Subsets the outliers from the given vector parameter by determining which values fall below or above
  # the outlier interval through inequalities.
  outliers = data[data < lower.bound | data > upper.bound]
  
  #mean.lower = mean(data) - 3*sd(data)
  #mean.upper = mean(data) + 3*sd(data)
  #mean.outliers = data[data < mean.lower | data > mean.upper]
  
  # Subsets the given vector paraemeter with data that falls within the outlier interval test.
  data.without.outliers = data[data > lower.bound & data < upper.bound]
  
  #print("removed outliers:")
  #print(outliers)
  #print("data without outliers:")
  #print(data.without.outliers)-
  
  return(data.without.outliers)
  
  
}
### END FUNCTION HERE ###

# Declares a new sample variable without outliers from the original samples.
new.insertion.sample = remove.outliers(insertion.sample)
new.selection.sample = remove.outliers(selection.sample)
new.quick.sample = remove.outliers(quick.sample)




##########################################
### SKEWNESS INDEX CALCULATOR FUNCTION ###
##########################################

skewness.index = function(data) {
  # pearson's skewness index test: 3(xbar - q2)/s
  index = 3*(mean(data) - median(data))/length(data)
  
  # if index is greater than 0.05, there is evidence of skew, otherwise there is no evidence of skew
  is.it.skewed = ifelse(index > 0.05, "evidence of skew", "no evidence of skew")
  
  print(is.it.skewed)
  print(paste("I = ", index))
  
}
### END OF FUNCTION ###

# After removing the outliers from the previous function, we check the skewness of the sample
# to determine normality of skew
skewness.index(new.insertion.sample)
skewness.index(new.selection.sample)
skewness.index(new.quick.sample)




#########################################################
### F ASSUMPTIONS / HOMOGENEITY OF VARIANCE FOR ANOVA ###
#########################################################

f.test = function(x,y,z) {
  
  # Finds the variance of the given vector parameters
  var.sample.x = var(x)
  var.sample.y = var(y)
  var.sample.z = var(z)
  
  # This is the homogeneity of variance/F tests for checking assumptions for ANOVA.
  # We intentionally make the numerator the greater variance (as a result, alpha is cut in half)
  f1 = (max(var.sample.x,var.sample.y)/min(var.sample.x,var.sample.y))
  f2 = (max(var.sample.x,var.sample.z)/min(var.sample.x,var.sample.z))
  f3 = (max(var.sample.y,var.sample.z)/min(var.sample.y,var.sample.z))

  return(paste("the following F-values for the given parameters are: ", f1, f2, f3))
}
### END OF FUNCTION ###
f.test(new.insertion.sample, new.selection.sample, new.quick.sample)
# "the following F-values for the given parameters are:  4.97064052442998 313.140730796326 62.9980641845421"
# Critical value is 4.03 w/ dfN = 9 and dfD = 9, with alpha = 0.025
# Reject null hypothesis for all 3 tests, thus the variances are significantly different.





######################
### ANOVA FUNCTION ###
######################

analysis.of.variance = function(list.of.samples) {
  y = unlist(list.of.samples)
  number.of.samples = length(list.of.samples)
  sample.sizes = unlist(lapply(list.of.samples,length))
  group = rep(1:number.of.samples,sample.sizes)
  data = data.frame(y = y, group = factor(group))
  fit = lm(y ~ group, data)
  anova(fit)
}
### END FUNCTION HERE ###

aov.results = analysis.of.variance(list(new.insertion.sample,new.selection.sample,new.quick.sample))
print(aov.results)
# F-value = 119.55, Pr(>F) is 1.593e-13*** < 0.001, so there is significant different somewhere,
# thus we proceed with Scheffe test




#############################
### SCHEFFE TEST FUNCTION ###
#############################

scheffe.test = function(aov.results, sample1, sample2, alpha) {
  s.w.squared = (aov.results$`Mean Sq`[2])
  n.1 = length(sample1)
  n.2 = length(sample2)
  F.s = (mean(sample1) - mean(sample2))^2/(s.w.squared*(1/n.1 + 1/n.2))
  deg.freedom.numerator = aov.results$Df[1]
  deg.freedom.denominator = aov.results$Df[2]
  anova.crit.value = qf(alpha,deg.freedom.numerator,deg.freedom.denominator,lower.tail=FALSE)
  scheffe.crit.value = deg.freedom.numerator * anova.crit.value
  return(c(scheffe.crit.value,F.s))
}
### END OF FUNCTION ###

# The following returns a vector containing the critical value (1st element) and test statistic (2nd element) from Scheffe
scheffe.test(aov.results, new.insertion.sample, new.selection.sample, 0.05)
# 6.77038 6.328279
scheffe.test(aov.results, new.insertion.sample, new.quick.sample, 0.05)
# 6.77038 206.98034
scheffe.test(aov.results, new.selection.sample, new.quick.sample, 0.05)
# 6.77038 139.37816
# We can see the quick.sample is significantly different from the other two



### CONCLUSION: From ANOVA, we reject the null hypothesis since Pr(>F) is 1.593e-13*** < 0.001, 
# and the test statistics from Scheffe's test are in the rejection region, except for insertion vs. selection.
### INFERENCE: There is evidence that quick sort is significantly different from insertion sort and selection sort.
### SURPRISING: This is not surprising because quick sort is probably called "quick sort" due to its
# quick sorting ability. It makes the most sense for a quick sorting method to be deemed "quick." 




#####################################
### NEW SAMPLE GENERATOR FUNCTION ###
#####################################
sample.generator = function(size, times.each, max, sort.type) {
  # Declares an empty vector for future use.
  this.vector = c()
  
  # This loop calculates the sorting time at each 'size' and appends it to the empty vector,
  # thus resulting in a vector of 80 elements from sorting varying vector sizes (sizes 10 - 800 considered)
  while (size <= max) {
    # Finds the sorting time of a given vector of size 'size' using the specific sorting method
    new.sample = sort.time(size,times.each,sort.type)
    this.vector = c(this.vector, new.sample)
    
    # Increments the size by 10 after each sort, thus illustrating increasing vector sizes being considered
    size=size+10
  }
    return(this.vector)
  
}
### END OF FUNCTION ###

# Creates a vector from 10...20...30...40...790...800
size.vector = seq(from=10,to=800,by=10)

# Creates new samples without outliers using each sorting method-- this time the vector
# contains times from increasing vector sizes that are being considered when being sorted.
different.insertion.sample = remove.outliers(sample.generator(size=10,times.each=10,max=800,sort.type=insertion.sort))
different.selection.sample = remove.outliers(sample.generator(size=10,times.each=10,max=800,sort.type=selection.sort))


# Creates a scatter plot of the previous samples, 
# sqrt'd to fit bivariate normal distribution assumptions for linearity.
# Initally, the plots for insertion and selection were quadratic.
plot(x=size.vector, y=sqrt(different.insertion.sample), main="scatter plot of insertion sort", ylab="time of sorting method (in seconds)", xlab="size of vector considered")








#################################
### CORRELATION TEST FUNCTION ###
#################################

correlation.test = function(vector.size, sample, alpha) {

  plot(x=vector.size, y=sample, main="scatter plot of insertion sort", ylab="time of sorting method (in seconds)", xlab="size of vector considered")
  abline(lm(sample ~ vector.size))
  
  # Calculates the correlation coefficient from given sample parameters: insertion and selection samples
  r = cor(vector.size, sample)
  print(paste("correlation coefficient is", r))
  
  # Calculates test statistic using correlation coefficient
  t = r*sqrt((length(sample)-2)/(1-r^2))
  print(paste("test statistic is", t))
  
  # Computes the p-value 
  p.value = 2*(1-pt(t,length(sample)-2))
  ifelse(p.value < alpha, paste("reject null, p-value is", p.value), paste("fail to reject null, p-value is", p.value))
}
### END OF FUNCTION ###

correlation.test(size.vector, sqrt(different.insertion.sample), 0.05)
# "correlation coefficient is 0.984312197882428" so it is significant
# "test statistic is 49.2713107747373"
# "reject null, p-value is 0", so the correlation between insertion sorting times and selection sorting times
# is highly significant.


# Regression line: intercept: 0.0005247, slope: 0.0006768
# y = 0.0006768x + 0.0005247
insertion.prediction = 0.0006768*1000 + 0.0005247
insertion.prediction
# 0.6773247 seconds


# Looking at the graph, a vector of size 1000 should take around 0.677 seconds for insertion sort.
### Should I be confident? No, since we rejected the t-test, we determined that the correlation between insertion sort and 
# vector size is highly significant, so the line of regression is not a good predictor. Also, we took the square root of the original
# y-values in order to demonstrate linearity


sort.time(1000,10,insertion.sort)
# Actual time: 0.4278491 ~ 0.458153 secs
# Our prediction was off by like 0.14 seconds

### Are we surprised? We are not surprised that R does not allow for insertion or selection sort because
# quick sort is overall faster at sorting than the other methods as the size of the vector
# being considered increases, and cost-time efficiency is the most important, thus it 
# would not be effective or make any sense to keep/recommend slower sorting methods; however,
# insertion sort is actually faster at sorting than quick sort initially (with lower n sizes),
# so this aspect is surprising because quick sort is not quick for all values of 'n'
