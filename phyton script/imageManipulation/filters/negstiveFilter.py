import cv2 as cv2


image = cv2.imread('../photo/cat.jpeg')




# Apply negative filter
negative_image = 255 - image

# Display the result
cv2.imshow('Negative Filter', negative_image)
cv2.waitKey(0)
cv2.destroyAllWindows()
