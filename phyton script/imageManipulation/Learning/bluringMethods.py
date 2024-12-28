import cv2 as c

img = c.imread('../photo/cat.jpeg')

# Apply Averaging Blur
kernel_size = (5, 5)
blurred_image = c.blur(img, kernel_size)
c.imshow('Averaging Blur', blurred_image)  # display image in different window

# Apply Gaussian Blur

blurred_image2 = c.GaussianBlur(img, kernel_size, sigmaX=0)
c.imshow('Gaussian Blur', blurred_image2)  # display image in different window

# Apply Median Blur

blurred_image3 = c.medianBlur(img, 5)  # Must be an odd number
c.imshow('Median Blur', blurred_image3)  # display image in different window

# Apply Bilateral Filter
diameter = 9
sigmaColor = 75
sigmaSpace = 75
blurred_image4 = c.bilateralFilter(img, diameter, sigmaColor, sigmaSpace)
c.imshow('Bilateral Blur', blurred_image4)  # display image in different window

c.waitKey(0) 
