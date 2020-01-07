#Emma Horsfield and Randy Truong worked together

rprobs = sample(1:5,5)
rprobs = rep(16*rprobs,each=20)
rprobs = rprobs + 20*runif(100)
rprobs = rprobs / sum(rprobs)
pop = sample(1:100,size=10000,replace=TRUE,prob=rprobs) 

population.hist = function(n) {
  
  # Creating first histogram (blue)
  hist(n,
       col="skyblue",
       main="Population",
       xlab="",
       breaks=seq(from=0.5,to=100.5,by=5))
}

population.hist(pop)


# Creating function for mean histograms
sample.means = function(pop,sample.size,n,title,show.overlay) {
  
  # Replicating all the means
  mean.sample.size = replicate(n,mean(sample(1:100,size=sample.size,replace=TRUE,prob=rprobs)))
  
  # Creating mean histogram
  mean.hist =hist(mean.sample.size,
             breaks = seq(from=0.5,to=100.5,by=5),
             plot = FALSE)
  max.rect.height = max(mean.hist$counts)
  
 
  # Getting xs and ys for curve
  xs = c(mean(pop), mean(pop) + sd(pop)/sqrt(sample.size))
  ys = c(dnorm(mean(pop) + sd(pop)/sqrt(sample.size), mean = mean(pop), sd = sd(pop)/sqrt(sample.size)) * n * 5, 
         dnorm(mean(pop) + sd(pop)/sqrt(sample.size), mean = mean(pop), sd = sd(pop)/sqrt(sample.size)) * n * 5
  )
  
  # Creates x-values that span across x-axis for normal dist. curve
  xc = seq(from=0.5,to=100.5,by=.1)
  
  # Creates y-values of normal distribution curve
  yc = dnorm(xc, mean = mean(pop), sd = sd(pop)/sqrt(sample.size)) * n * 5
  
  max.curve.y = max(yc)

  absolute.max = max(c(max.curve.y,max.rect.height))

  mean.hist = hist(mean.sample.size,
           col="green",
           main=title,
           xlab="",
           ylim=c(0, absolute.max),
           breaks=seq(from=0.5,to=100.5,by=5),
           plot=TRUE
  )
  
  #If true, displays normal dist. curve + relative lines on histogram
  if(show.overlay==TRUE) {

    # Draws normal dist. curve on histogram
    lines(xc, yc)
    
    # Draws blue vertical line to show center
    abline(v=mean(pop),col="blue",lwd=3)
    
    # Draws red horizontal line that begins in center and ends where line touches curve
    lines(xs, ys, col="red", lwd=3)
  }
}

par(mfcol=c(3,3))
population.hist(pop)
sample.means(pop,2,1000,"Sample Means (n=2)",FALSE)
sample.means(pop,2,1000,"Sample Means (n=2)",TRUE)
population.hist(pop)
sample.means(pop,4,1000,"Sample Means (n=4)",FALSE)
sample.means(pop,4,1000,"Sample Means (n=4)",TRUE)
population.hist(pop)
sample.means(pop,15,1000,"Sample Means (n=15)",FALSE)
sample.means(pop,15,1000,"Sample Means (n=15)",TRUE)