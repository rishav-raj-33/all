import cv2 as c
import numpy as num

blank = num.zeros((500,500,3),dtype='uint8')

# paint the image a certain colour.

blank[:] = 0, 255, 0
c.imshow('Green', blank)  # display image in different window

#paint certain pixels

blank[200:300,300:400] = 0, 255, 0

c.imshow('Pixel Range', blank)  # display image in different window

#draw a rectangle in image

c.rectangle(blank,(0,0),(250,250),(0,255,0),thickness=c.FILLED)

c.imshow('Rectangle', blank)  # display image in different window


c.waitKey(0)
