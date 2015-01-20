class Solution:
    key_mapping = {2:['a','b','c'],
                   3:['d','e','f'],
                   4:['g','h','i'],
                   5:['j','k','l'],
                   6:['m','n','o'],
                   7:['p','q','r','s'],
                   8:['t','u','v'],
                   9:['w','x','y','z'],
                  }
    known_words = []
    reverse_key_mapping = {}
    nwords = 0
    key_combinations = [] # Stores the key combinations for all possible values
    max_combi_freq = None # The max freq. of number combination
    max_combi = None # The combination containing the max frequency
    def construct_reverse_mapping(self):
        for key, value in self.key_mapping.iteritems():
            for item in value:
                self.reverse_key_mapping[item] = key

    def add_known_words(self,word):
        self.known_words.append(word)

    def construct_key_combinations(self):
        """
            For each word in the known words list,
            this method will construct the key combination and append it
            to the key_combinations list.
        """
        if len(self.reverse_key_mapping) == 0:
            self.construct_reverse_mapping()
        for word in self.known_words:
            temp_combi = ''
            for char in word:
                temp_combi += str(self.reverse_key_mapping[char])
            self.key_combinations.append(temp_combi)
        self.key_combinations.sort()

    def find_max_combinations(self):
        """
            Once the key combinations have been constructed and sorted,
            this method finds out that key combination that occurrs the maximum
            number of times
        """
        max_combi_freq = -1
        max_combi = None
        prev_combi = None
        combi_freq = 0
        for combi in self.key_combinations:
            if prev_combi == combi:
                combi_freq +=1
            if prev_combi != combi:
                if combi_freq > max_combi_freq:
                    max_combi_freq = combi_freq
                    max_combi = prev_combi
                combi_freq = 0
            prev_combi = combi
        if combi_freq > max_combi_freq:
            max_combi_freq = combi_freq
            max_combi = prev_combi
        self.max_combi_freq = max_combi_freq
        self.max_combi = max_combi                                                    


## MAIN ##
sms_obj = Solution()
sms_obj.nwords = int(raw_input())
i=0
while (i<sms_obj.nwords):
    sms_obj.add_known_words(raw_input())
    i+=1
sms_obj.construct_reverse_mapping()
sms_obj.construct_key_combinations()
sms_obj.find_max_combinations()
print sms_obj.max_combi
