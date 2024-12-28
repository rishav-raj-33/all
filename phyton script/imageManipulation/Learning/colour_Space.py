import cv2 as c
import matplotlib.pyplot as plt



img = c.imread('../photo/cat.jpeg')

# c.imshow('cat', img)   # display image in different window


#filer

plt.imshow(img)
plt.show()


# c.waitKey(0)        # wait infinite time till any key to be pressed