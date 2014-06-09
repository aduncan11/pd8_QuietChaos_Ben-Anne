pd8_QuietChaos_Ben-Anne
=======================

Driver: -uses scanner to set up the user account
  - makes a priority queue with parts of the story and mini games
  -   the queue has some decision stuff in it (somehow? not sure how to do this)
  - depending on ending stats of user, win or lose.

Character:
  - int _socialLife: how popular they are
    int _sleep: how rested they are
    int _grades: how hard they work/smart they are
    String gender: to determine some gender pronouns, or love interest (all the people at this school happen to be straight.)
    String _name: this should not need explanation. 
  - all the variables can change, depending on behavior. (example: good social interaction increases your social life)

  -UserCharacter: 
    Character _loveInterest: boyfriend/girlfriend
    PriorityQueue<ComputerCharacter> _friends: a priority queue of friends that is ranked by how close they are (an int instance var in the computercharacter class)
      - helps establish who to hang out with
  - constructor asks for type of user (nerd, jock, narcoleptic) which helps to determine starting stats, entirely based on offensive stereotypes
  
  - ComputerCharacter:
  -   friendliness variable is how close they are with the user
  -   they get a random name
  -   they are a computer. do not think they are your friends.
  
StoryBit:
  super class for all the pieces of the story.

SocialStory:
  interaction with a random friend. if you succeed (you care, or you don't care for good reasons) you are okay. if not you lose social status and don't make a new friend :(
  
SchoolStory:
  subject-related trivia questions
  
Math/History/English/Science Story: 
  -Extend School Story.
  -Holds the specific questions for each unique topic.

DecisionStory:
  you choose what to do (socialize, sleep, or study) 
  this should be more frequent in the queue

MiniGames:
  what are they? but they will be interspersed, and affect all stats. 
  
