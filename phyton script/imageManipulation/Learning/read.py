import os

import cv2 as c


img = c.imread('../photo/cat.jpeg')

c.imshow('cat', img)   # display image in different window

c.waitKey(0)        # wait infinite time till any key to be pressed


#print(os.path.exists('../photo/cat.jpeg'))   //check if file exist or not


