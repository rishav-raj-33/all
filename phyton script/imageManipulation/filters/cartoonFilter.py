import cv2 as cv2


image = cv2.imread('../photo/cat.jpeg')



# Convert to grayscale
gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Apply median blur
blurred = cv2.medianBlur(gray_image, 7)

# Detect edges
edges = cv2.adaptiveThreshold(blurred, 255, cv2.ADAPTIVE_THRESH_MEAN_C,
                              cv2.THRESH_BINARY, 9, 10)

# Reduce color palette
color_reduced = cv2.bilateralFilter(image, d=9, sigmaColor=75, sigmaSpace=75)

# Combine edges with reduced color image
cartoon_image = cv2.bitwise_and(color_reduced, color_reduced, mask=edges)

# Display the result
cv2.imshow('Cartoon Filter', cartoon_image)
cv2.waitKey(0)
cv2.destroyAllWindows()
