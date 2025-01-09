import cv2 as cv2
import numpy as np

image = cv2.imread('../photo/cat.jpeg')




# Create a sepia filter matrix
sepia_filter = np.array([[0.272, 0.534, 0.131],
                         [0.349, 0.686, 0.168],
                         [0.393, 0.769, 0.189]])
sepia_image = cv2.transform(image, sepia_filter)
sepia_image = np.clip(sepia_image, 0, 255).astype(np.uint8)

# Display the result
cv2.imshow('Sepia Filter', sepia_image)
cv2.waitKey(0)
cv2.destroyAllWindows()
