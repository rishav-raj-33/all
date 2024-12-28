import cv2 as cv2
import numpy as np

image = cv2.imread('../photo/cat.jpeg')


# Create an emboss kernel
kernel = np.array([[-2, -1, 0],
                   [-1, 1, 1],
                   [0, 1, 2]])
emboss_image = cv2.filter2D(image, -1, kernel)

# Display the result
cv2.imshow('Emboss Filter', emboss_image)
cv2.waitKey(0)
cv2.destroyAllWindows()
