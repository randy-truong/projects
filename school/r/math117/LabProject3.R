#Emma Horsfield and Randy Truong worked together



################################
### DARTS SIMULATOR FUNCTION ###
################################

num.darts.inside = function(n, show) {
  xs = c(runif(n, min = -1, max = 1)) # create n values between -1 and 1 and put inside vector for x-values
  ys = c(runif(n, min = -1, max = 1)) # create n values between -1 and 1 and put inside vector for y-values
  
  point.radius = c(sqrt(xs*xs + ys*ys)) # calculate length of point from origin (pythagorean theorem)
  within.circle = (point.radius <= 1) # if hypotenuse > 1 (radius of circle), then it is beyond the circle
  cols = ifelse(within.circle, "red", "blue") # if point outside of circle, then it is blue; if it is within circle, then it is red.
  
  proportion.in.circle = c(within.circle) # create vector determining which points are inside (TRUE) or outside (FALSE) circle
  total.reds = sum(proportion.in.circle) # since TRUE = 1 and FALSE = 0, then the sum of TRUE = total number of points in circle
  
  # display plot if true
  if (show == TRUE) {
    plot(xs,ys,pch=20,col=cols, xlab="", ylab="", main="Darts Thrown", xlim=c(-1,1), ylim=c(-1,1))
  }
  
  return(total.reds)
}
### END THIS FUNCTION ###

4*num.darts.inside(1000,TRUE)/1000



################################################
### DISTRIBUTION OF DARTS HISTOGRAM FUNCTION ###
################################################

analysis = function(n) {
  xs = c(runif(n, min = -1, max = 1)) # create n values between -1 and 1 and put inside vector for x-values
  ys = c(runif(n, min = -1, max = 1)) # create n values between -1 and 1 and put inside vector for y-values
  
  point.radius = c(sqrt(xs*xs + ys*ys)) # calculate length of point from origin (pythagorean theorem)
  within.circle = (point.radius <= 1) # if hypotenuse > 1 (radius of circle), then it is beyond the circle
  
  proportion.in.circle = c(within.circle) # create vector determining which points are inside (TRUE) or outside (FALSE) circle
  total.reds = sum(proportion.in.circle) # since TRUE = 1 and FALSE = 0, then the sum of TRUE = total number of points in circle
  
  # distribution of the number of darts out of n thrown that landed inside circle, based on 10000 trials
  darts.sample.size = sample(1:n,size=10000,replace=TRUE,prob=(dbinom(1:n, size = n, prob = pi/4)))
  
  # create blank histogram to find max bar height and absolute height for setting ylim in the future
  distribution.of.darts.hist = hist(darts.sample.size,
                                    breaks=seq(from=-0.5, to=n+0.5, by=1),
                                    plot=FALSE)
  # count the frequency of each bar, then find the bar with the most (max)
  max.rect.height = max(distribution.of.darts.hist$counts)
  
  # calculate expected mean of darts inside circle using n*p
  np = signif(n*(pi/4), digits = 4)
  
  # calculate expected mean of darts outside circle using n*q
  nq = signif(n*(1-(pi/4)), digits = 4)
  
  # calculated expected standard deviation of darts using sqrt(n*p*q)
  sd.npq = signif(sqrt(n*(pi/4)*(1-(pi/4))), digits = 4)
  
  
  # create and declare x- and y- values for curve
  xc = seq(from=0,to=n,by=.0001) # use length.out?
  yc = dnorm(xc, mean = np, sd = sd.npq) * 10000
  
  # find max y-value on curve
  max.curve.y = max(yc)
  
  # take the max value from vector containing max bar value and max curve value
  absolute.max = max(c(max.curve.y, max.rect.height))
  
  
  # calculate mean darts from the previous sample, rounded to 4 digits
  mean.darts = signif(mean(sample(1:n,size=10000,replace=TRUE,prob=(dbinom(1:n, size = n, prob = pi/4)))), digits = 4)
  
  # calculate sd of darts from previous sample, rounded to 4 digits
  sd.darts = signif(sd(sample(1:n,size=10000,replace=TRUE,prob=(dbinom(1:n, size = n, prob = pi/4)))), digits = 4)
  
 
  
  # percentage of trials resulting in num. of darts being <= n
  predicted.percent = signif(pnorm(n+0.5, mean=mean.darts, sd=sd.darts), digits = 4)
  
  # create histogram of darts sample size
  title = paste0("Darts Inside Circle (out of ", n, " thrown)")
  distribution.of.darts.hist = hist(darts.sample.size,
                                    main=title,
                                    xlim=c(0,n+0.5),
                                    ylim=c(0,absolute.max),
                                    xlab="number of darts",
                                    ylab="frequency",
                                    breaks=seq(from=-0.5, to=n+0.5, by=1))
  # draw red normal curve 
  lines(xc, yc, col = "red")
  
  # print text
  mean.text = paste0("mean number of darts inside the circle: ", mean.darts, " (", np, " expected)") 
  sd.text = paste0("standard deviation of the number of darts inside the circle: ", sd.darts, " (", sd.npq, " expected)")
  np.text = paste0("np = ", np, "")
  nq.text = paste0("nq = ", nq, "")
  prediction.text = paste0("predicted percentage of darts using normal model <= ", n, ": ", predicted.percent, " (expected 1.00)")
  text.output = c(mean.text, sd.text, np.text, nq.text, prediction.text)
  
  return(paste(text.output))
}
### END THIS FUNCTION ###

### QUESTION 1 ###
# The predicted percentage is not closest when n is less than 24, because nq is not >= 5.
# Anything greater than 24 is closer because np >= 5 and nq >= 5, but as n approaches 49 or 50 or anything greater,
# the predicted percentage is closest to 1.
# As n increases, np and nq increases; however,
# if n is a lower value, such as 12, np is >= 5, but nq is not >= 5, .

analysis(12)



######################################
### SAMPLING DISTRIBUTION FUNCTION ###
######################################

sampling.distribution = function(n, p.hat) {
  
  # distribution of the number of darts out of n thrown that landed inside circle, based on 10000 trials
  darts.sample.size = sample((1:n)/n,size=10000,replace=TRUE,prob=(dbinom(1:n, size = n, prob = pi/4)))
  
  # create histogram using darts.sample.size, but do not plot in order to find ylim height
  h=hist(darts.sample.size,
         breaks=seq(from=-1/(2*n),to=1+(1/(2*n)),by=1/n),
         plot=FALSE)
  
  # creates x-values for the normal distribution curve
  xt=seq(from=0,to=1.05,by=0.001)
  
  # creates y-values for the normal distribution curve
  yt=dnorm(xt,mean=pi/4,sd=sqrt(((pi/4)*(1-pi/4))/n)) * (10000/n)
  
  # finds the max y-value of the curve
  max.curve.yt = max(yt)
  
  # finds the bar with the highest frequency (max y-value of bars)
  max.bar.h = max(h$counts)
  
  # determines which y-value is higher given the max curve-y and max bar-y
  absolute.sample.max = max(c(max.curve.yt,max.bar.h))
  
  # inequality that determines which values are less than p.hat
  less.than.phat = (seq(from=0,to=1+(1/(2*n)),by=1/n) < p.hat)
  
  # if values are less than p.hat, the bars on the histogram to the left of p.hat are colored blue
  bar.col = ifelse(less.than.phat, "blue", "white")
  
  # calculates the probability of the area to the left of p.hat
  dart.area.approximation = signif(pnorm(p.hat,pi/4,sqrt(((pi/4)*(1-pi/4))/n)),digits=2)
  
  # creates histogram of sample proportions but plots it
  hist(darts.sample.size,
       main="Distribution of Sample Proportions",
       xlim=c(0,1),
       ylim=c(0,absolute.sample.max),
       xlab="sample proportions",
       ylab="frequency",
       breaks=seq(from=-1/(2*n),to=1+1/(2*n),by=1/n),
       col = bar.col
  )
  
  # draws normal curve on top of histogram
  lines(xt,yt, col="red")
  
  return(paste0("probability of seeing less than ", p.hat, " is ", dart.area.approximation))
}
### END OF FUNCTION ###

### QUESTION 2 ###
# It is appropriate to calculate probabilities of seeing certain sample proportions
# using the normal distribution when np >= 5 and nq >= 5.

sampling.distribution(50,0.72)
