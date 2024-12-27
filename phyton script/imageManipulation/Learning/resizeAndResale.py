import cv2 as c


def rescaleFrame(frame, scale=0.2):
    width = int(frame.shape[1] * scale)
    height = int(frame.shape[1] * scale)
    dimension =(width,height)

    return c.resize(frame,dimension, interpolation=c.INTER_AREA)


img = c.imread('../photo/cat.jpeg')

reSize=rescaleFrame(img)

c.imshow('cat', reSize)

c.waitKey(0)