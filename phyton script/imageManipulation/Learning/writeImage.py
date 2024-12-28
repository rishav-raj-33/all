import cv2 as c


img = c.imread("../photo/cat.jpeg")

gray = c.cvtColor(img,c.COLOR_BGR2GRAY)

c.imwrite('image.jpg', gray)