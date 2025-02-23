class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if(sqrt(num)%1==0):
            return True
        else:
            return False
        