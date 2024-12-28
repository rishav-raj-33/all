import cv2 as cv2


image = cv2.imread('../photo/cat.jpeg')


# Convert to grayscale
gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Apply Canny edge detection
edges = cv2.Canny(gray_image, threshold1=100, threshold2=200)

# Display the result
cv2.imshow('Edge Detection Filter', edges)
cv2.waitKey(0)
cv2.destroyAllWindows()
