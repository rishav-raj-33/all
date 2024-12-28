import cv2 as c
import numpy as num

img = c.imread('../photo/cat.jpeg')

c.imshow('cat', img)   # display image in different window
grey = c.cvtColor(img,c.COLOR_BGR2GRAY)

ret,thres = c.threshold(grey,125,125,c.THRESH_BINARY)


# contours

contrours,hi=c.findContours(thres,c.RETR_LIST,c.CHAIN_APPROX_SIMPLE)

blank=num.zeros(img.shape,dtype='uint8')

c.drawContours(blank,contrours,-1,(0,0,255),2)
c.imshow('draw cat', blank)   # display image in different window



c.waitKey(0)        # wait infinite time till any key to be pressed