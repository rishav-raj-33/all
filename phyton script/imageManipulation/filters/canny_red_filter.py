import cv2 as c
import numpy as num

img = c.imread('../photo/cat.jpeg')

c.imshow('cat', img)   # display image in different window
grey = c.cvtColor(img,c.COLOR_BGR2GRAY)

#ret,thres = c.threshold(grey,125,125,c.THRESH_BINARY)
gray_image = c.cvtColor(img, c.COLOR_BGR2GRAY)
edges = c.Canny(gray_image, threshold1=100, threshold2=200)

# contours

contrours,hi=c.findContours(edges,c.RETR_LIST,c.CHAIN_APPROX_SIMPLE)

blank=num.zeros(img.shape,dtype='uint8')

c.drawContours(blank,contrours,-1,(0,0,255),2)

c.imshow('cat', blank)

c.waitKey(0)
