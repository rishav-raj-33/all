import cv2 as cv2
import numpy as np
import sys


def canny(image):
    gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    # Apply Canny edge detection
    edges = cv2.Canny(gray_image, threshold1=100, threshold2=200)
    cv2.imwrite("images.jpeg", edges)


def canny_red(image):
    grey = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    edges = cv2.Canny(gray_image, threshold1=100, threshold2=200)
    contrours, hi = cv2.findContours(edges, cv2.RETR_LIST, cv2.CHAIN_APPROX_SIMPLE)
    blank = np.zeros(image.shape, dtype='uint8')
    cv2.drawContours(blank, contrours, -1, (0, 0, 255), 2)
    cv2.imwrite("image.jpeg", blank)


def cartoon(image):
    gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    blurred = cv2.medianBlur(gray_image, 7)
    edges = cv2.adaptiveThreshold(blurred, 255, cv2.ADAPTIVE_THRESH_MEAN_C,
                                  cv2.THRESH_BINARY, 9, 10)
    color_reduced = cv2.bilateralFilter(image, d=9, sigmaColor=75, sigmaSpace=75)
    cartoon_image = cv2.bitwise_and(color_reduced, color_reduced, mask=edges)
    cv2.imwrite("image.jpeg", cartoon_image)


def emboss(image):
    kernel = np.array([[-2, -1, 0],
                       [-1, 1, 1],
                       [0, 1, 2]])
    emboss_image = cv2.filter2D(image, -1, kernel)
    cv2.imwrite("image.jpeg", emboss_image)


def grayScale(image):
    gray_image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    cv2.imwrite("image.jpeg", gray_image)


def lapsian(image):
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    lap = cv2.Laplacian(gray, cv2.CV_64F)
    lap = np.uint8(np.absolute(lap))
    cv2.imwrite("image.jpeg", lap)


def sepia(image):
    sepia_filter = np.array([[0.272, 0.534, 0.131],
                             [0.349, 0.686, 0.168],
                             [0.393, 0.769, 0.189]])
    sepia_image = cv2.transform(image, sepia_filter)
    sepia_image = np.clip(sepia_image, 0, 255).astype(np.uint8)
    cv2.imwrite("image.jpeg", sepia_image)


def negative(image):
    negative_image = 255 - image
    cv2.imread("image.jpeg", negative_image)


def getImage():
    image = cv2.imread("")
    return image


def switch_case(option):
    match option:
        case 1:
            return canny(getImage())
        case 2:
            return canny_red(getImage())
        case 3:
            return cartoon(getImage())
        case 4:
            return emboss(getImage())
        case 5:
            return lapsian(getImage())
        case 6:
            return grayScale(getImage())
        case 7:
            return sepia(getImage())
        case 8:
            return negative(getImage())


number = int(sys.argv[1])
switch_case(number)
