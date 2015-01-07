class anagram:
    char_dict = {}
    test_string = None
    anagram_pairs = [] # list of lists. Of structure [[[start, end],[anagram_start, anagram_end]],<second anagram_pair>]
    length = None

    def __init__(test_string):
        self.test_string = test_string
        self.length = len(test_string)
        build_char_dict()

    def build_char_dict(test_string=self.test_string):
        """
            build character dictionary from the given string
        """
        self.char_dict = {}
        length = len(test_string)
        i=0
        while i<length:
            if self.char_dict.get(test_string[i]):
                self.char_dict[test_string[i]].append(i)
            else:
                self.char_dict[test_string[i]]=[i]
            i+=1
    def test_sequence(positions):
        """
            Given a sequence of numbers, tells if they are in sequence or not
        """
        positions.sort()
        temp_list = range(min(positions),max(positions)+1)
        if temp_list == positions:
            return True
        return False

    def test_anagram(actual_string, sub_string):
        """
            tells whether the actual_string has
            an anagram of the substring or not.
            If yes, returns a list
            Tests if anagram or not
             -- Takes a char, checks for second occurrence
             -- Takes the next char, checks for second occurrence
                -- If second occurrence - first occurrence < len(substring)
                   -- Take the next char and do the same
                -- Else back track to the next occurrence and so on
                    -- If not fulfilled, return False
        """
        positions = []

        

    
    def get_distinace_array()
        """
            Goes through the string char by char and refers the char_dict.
            For one char anagrams, directly adds them to the anagram_pairs.
            For the rest, it returns a list of dictionary of the following format
                {'char':position, 'char':position}            
            and length of sub string
        """
        start_index = 0
        end_index = 0
        while start_index < self.length:
            anagram_length = 0
            temp_occurrences = self.char_dict[self.test_string[end_index]]
            if len(temp_occurrences) == 1:
                start_index+=1
                end_index+=1
                continue
            else:
                for occurrence in temp_occurrences:
                    if occurrence != start_index:
                        anagram_start_index = occurrence
                        anagram_end_index = occurrence
                        self.anagrams.append([[start_index,end_index],[anagram_start_index,anagram_end_index]])
                        end_index+=1

                        break
                    else:
                        continue


    def check_anagram(substring, distance_dict)
        """
            Given a distance dictionary and the substring whose anagram
            the distance dict is supposed to determine, will tell if the
            distance_dict represents a rearranged substring within the same string
            therby forming an anagram of the given substring. Returns a boolean            
        """
t = int(raw_input())
answers = []
    # Building the anagram list
    start_index=0
    end_index=0
    while start_index<length:
        # one char anagrams
        temp_char = test_string[end_index]
        temp_list = 
        start_index+=1
print anagram_pairs            
