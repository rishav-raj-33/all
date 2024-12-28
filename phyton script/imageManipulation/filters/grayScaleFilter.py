import cv2 as cv2


image = cv2.imread('../photo/cat.jpeg')

# Convert to grayscale
gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Display the result
cv2.imshow('Grayscale Filter', gray_image)
cv2.waitKey(0)
cv2.destroyAllWindows()
