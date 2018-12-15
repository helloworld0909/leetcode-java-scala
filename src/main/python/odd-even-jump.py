import random


def oddEvenJump(inputList):
    if not inputList:
        return 0

    oddSuccess = [False] * len(inputList)
    evenSuccess = [False] * len(inputList)
    oddSuccess[-1] = True
    evenSuccess[-1] = True

    successCount = 1

    for i in reversed(range(len(inputList) - 1)):
        oddFind = jump(inputList, i, -1)
        evenFind = jump(inputList, i, 1)
        if (oddFind != -1 and evenSuccess[oddFind] == True):
            oddSuccess[i] = True
            successCount += 1
        if (evenFind != -1 and oddSuccess[evenFind] == True):
            evenSuccess[i] = True
    return successCount


def jump(inputList, start, sign):
    num = inputList[start]
    minDiff = float("inf")
    index = -1
    for i in range(start + 1, len(inputList)):
        if (num - inputList[i]) * sign > 0 and abs(num - inputList[i]) < minDiff:
            minDiff = abs(num - inputList[i])
            index = i
    return index

# Test code below

def bruteForce(inputList):
    if not inputList:
        return 0

    count = 1
    for i in range(len(inputList) - 1):
        sign = -1
        while(True):
            i = jump(inputList, i, sign)
            sign *= -1
            if (i == -1):
                break
            if (i == len(inputList) - 1):
                count += 1
                break
    return count


if __name__ == "__main__":

    for length in range(200):

        inputList = []
        for _ in range(length):
            inputList.append(random.randint(1, 10000))

        myoutput = oddEvenJump(inputList)
        bruteoutput = bruteForce(inputList)
        if myoutput != bruteoutput:
            print(inputList, myoutput, bruteoutput)
