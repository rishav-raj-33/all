import cv2
import cv2 as c


img = c.imread('../photo/cat.jpeg')

c.imshow('cat', img)   # display image in different window


# converting to greyscale

grey = c.cvtColor(img,c.COLOR_BGR2GRAY)

c.imshow('GREY CAT', grey)   # display image in different window

# Blur the image

blur = c.GaussianBlur(img,(1,1),c.BORDER_DEFAULT)

c.imshow('Blur CAT', blur)   # display image in different window

# Edge Cascade

canny = c.Canny(img,125,175)
c.imshow('Canny CAT', canny)   # display image in different window

# Dilating the image
dilating = c.dilate(canny,(7,7),iterations=1)
c.imshow('dilating CAT', dilating)   # display image in different window

# Eroading

erroded = c.erode(dilating,(3,3),iterations=1)

# resize

resized = c.resize(img,(500,500),interpolation=c.INTER_AREA) #if srinking the image

#resized = c.resize(img,(500,500),interpolation=c.INTER_CUBIC) #if expaning the image
 # or (c.INTER_LINEAR)

c.imshow('resized CAT', resized)   # display image in different window

# Cropping the image based on pixel value

crop = img[50:200,200:400]
c.imshow("Cropped Image",crop)


c.waitKey(0)        # wait infinite time till any key to be pressed
