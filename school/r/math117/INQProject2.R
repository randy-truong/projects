# Emma Horsfield and Randy Truong worked together.

library("readxl")
getwd()
setwd("/Users/panda/Desktop/")

excelData = read_excel("tardigrade_data.xlsx")

georgia.elevations = excelData$georgia
georgia.elevations <- georgia.elevations[!is.na(excelData$georgia)]

colorado.elevations = excelData$colorado
colorado.elevations <- colorado.elevations[!is.na(excelData$colorado)]

japan.elevations = excelData$colorado
japan.elevations <- japan.elevations[!is.na(excelData$japan)]


################################
### OUTLIER REMOVER FUNCTION ###
################################

remove.outliers = function(data) {
  # outlier test: Q1 - 1.5IQR
  lower.bound = quantile(data,0.25) - 1.5*IQR(data)
  
  # outlier test: Q3 + 1.5IQR
  upper.bound = quantile(data,0.75) + 1.5*IQR(data)

  # subset the data given the condition that data is > lower and < upper bounds
  outliers = data[data < lower.bound | data > upper.bound]

  print("removed outliers:")
  print(outliers)

}
### FUNCTION ENDS HERE ###

remove.outliers(georgia.elevations)


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
### FUNCTION ENDS HERE ###

skewness.index(georgia.elevations)


###################################################
### MY QQ-PLOT WITHOUT USING ANY QQ()s FUNCTION ###
###################################################

my.qqplot = function(data) {
  
  # set lower bound as the minimum value of data set
  lower.bound = min(data)
  
  # set upper bound as given by outlier test: Q3 + 1.5IQR
  upper.bound = quantile(data,0.75) + 1.5*IQR(data)

  # sorts data from lowest to greatest
  ys = sort(data)
  
  # creates x-values for cut off values
  xs = qnorm(p=seq(from=0,to=1,length.out=length(data)), mean=mean(data), sd=sd(data))
  
  graph = plot(x=xs,
                y=ys,
                type="p", 
                xlab="cutoff values from a normal distribution", 
                ylab="sorted sample data", 
                main="My QQ-Plot",
                ylim=c(lower.bound, upper.bound))
  
  # draw y=x line relative to data
  lines(c(xs, ys), c(xs, ys), col="red")
}
### FUNCTION ENDS HERE ###

my.qqplot(georgia.elevations)
#my.qqplot(colorado.elevations)
#my.qqplot(rchisq(150,2))



#######################
### NORMAL FIT TEST ###
#######################

norm.fit.test = function(data, min.exp.in.bin) {
  # number of bins, truncating as to not round up
  bins = length(data)%/%(min.exp.in.bin)

  bin.cutoffs = qnorm((0:bins)/bins,mean(data),sd(data))

  
  h = hist(x=data,breaks=bin.cutoffs,plot=FALSE)
  observed.values = c(h$counts)
  expected.values = length(data)/bins
  
  total = sum(c(rep(expected.values,length(observed.values))))
  prob = c(rep(expected.values,length(observed.values)))/total
  
  c = chisq.test(x=observed.values,p=prob)
  
  print("observed:")
  print(observed.values)
  print("expected count in each bin:")
  print(expected.values)
  
  return(c)
}

### FUNCTION ENDS HERE ###
norm.fit.test(colorado.elevations,20)
#norm.fit.test(georgia.elevations,20)


### INQUIRY QUESTIONS ###
#6) Use t-test
t.test(x = japan.elevations, 
       mu = 200, 
       alternative = "two.sided", 
       conf.level=.95)
# Conclusion and reason: Reject the null hypothesis because p-value < .05
# Inference: There is enough evidence to reject the claim that the mean 
# elevation for the Japan tardigrades is 200 feet.
# Reliable? The inference is VERY reliable because the p-value is ridiculously small (2.2e^-16)
# which in comparison to the significance level is <.

#7) The confounding variable in this situation would be the location. 
# With respect to Denver being called Mile High City, it doesn't matter 
# the species because of the fact that there are tardigrades at such high elevation,
# so the species in Japan does not really matter.
