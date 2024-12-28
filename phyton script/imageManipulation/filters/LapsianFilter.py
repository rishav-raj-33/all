import cv2 as c
import numpy as num


img = c.imread('../photo/cat.jpeg')

gray =c.cvtColor(img,c.COLOR_BGR2GRAY)

lap = c.Laplacian(gray,c.CV_64F)
lap=num.uint8(num.absolute(lap))

c.imshow("Lapasian",lap)

c.waitKey(0)


