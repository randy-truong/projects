//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.xml.soap.Text;

import acm.breadboards.NoButtonsBreadboard;
import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

// This program is supposed to be an interactive visual novel with events that are called from other classes.
// All details and narrative are completely FICTIONAL
// Story was Eric Gu's idea

public class Main extends NoButtonsBreadboard {
	// Variables declared for future use
	EricCharacter eric;
	RandyCharacter randy;
	PurkisCharacter purkis;
	StevenCharacter steven;
	TermCharacter terminator;
	PaulCharacter paul;

	Background background;
	FirstEndingBackground ending1;
	SecondEndingBackground ending2;
	ThirdEndingBackground ending3;
	
	GLabel startButton;
	GLabel howToPlayButton;
	GLabel creditsButton;
	GLabel backButton;
	GLabel mainLabel;
	GLabel nextButton;
	GLabel howToPlayText;
	GLabel creditsText;

	JTextArea textArea;

	static int score = 0;
	int points;
	private int nextButtonClickCount;

	public static final int BREADBOARD_WIDTH = 960;
	public static final int BREADBOARD_HEIGHT = 544;

	public void run() {
		// Creating the canvas size
		this.setSize(BREADBOARD_WIDTH, BREADBOARD_HEIGHT + this.getRegionPanel(NORTH).getHeight());
		// this.setSize(BREADBOARD_WIDTH, BREADBOARD_HEIGHT);
		this.getRegionPanel(NORTH).setVisible(true);
		// this.getRegionPanel(EAST).setVisible(false);

		// Instantiating background variable
		background = new Background(nextButtonClickCount);
		background.setVisible(true);
		// background.setSize(BREADBOARD_WIDTH, BREADBOARD_HEIGHT);
		this.add(background);

		
		this.getTextArea().setText("Please play with the System Console output opened.");
		// Calling character classes to create GImage associated with file name, sets location
		purkis = new PurkisCharacter(50, 179);

		randy = new RandyCharacter(494, 108);
		eric = new EricCharacter(494, 179);
		paul = new PaulCharacter(494, 179);
		steven = new StevenCharacter(494, 193);
		terminator = new TermCharacter(323, 30);

		
		// Instantiating labels that will be used as buttons in the program
		startButton = new GLabel("Start");
		startButton.setColor(Color.BLUE);
		startButton.setFont("Arial-BOLD-18");
		this.add(startButton, (BREADBOARD_WIDTH - startButton.getWidth()) / 2, 300);

		howToPlayButton = new GLabel("How To Play");
		howToPlayButton.setColor(Color.BLUE);
		howToPlayButton.setFont("Arial-BOLD-18");
		this.add(howToPlayButton, (BREADBOARD_WIDTH - howToPlayButton.getWidth()) / 2, 350);

		creditsButton = new GLabel("Credits");
		creditsButton.setColor(Color.BLUE);
		creditsButton.setFont("Arial-BOLD-18");
		this.add(creditsButton, (BREADBOARD_WIDTH - creditsButton.getWidth()) / 2, 400);

		backButton = new GLabel("Back");
		backButton.setVisible(true);
		backButton.setFont("Arial-BOLD-18");
		backButton.setColor(Color.BLUE);

		this.nextButton = new GLabel("Next", BREADBOARD_WIDTH - 100, BREADBOARD_HEIGHT - (BREADBOARD_HEIGHT / 8));
		this.nextButton.setVisible(true);
		this.nextButton.setFont("Arial-BOLD-20");
		this.nextButton.setColor(Color.BLUE);

		// Adding an action listener, specifically mouse to GLabel so that it can act as
		// a "button" when clicked
		nextButton.addMouseListener(
				////////////////////////////////
				new MouseListener() {
					public void mouseClicked(MouseEvent arg0) {
						// When clicked, increase a counter, remove everything on screen and adding new
						// components.

						nextButtonClickCount++;
						Main.this.removeAll();
						Main.this.setSize(BREADBOARD_WIDTH,
								BREADBOARD_HEIGHT + Main.this.getRegionPanel(NORTH).getHeight());
						Main.this.getTextArea().setText("");
						Main.this.getTextArea().setLineWrap(true);
						Main.this.getTextArea().setWrapStyleWord(true);
						// Screen3.this.add(nextButton);
						// background = new Background(nextButtonClickCount);
						switch (nextButtonClickCount) {

						// Switch between background scenes according to button click counter

						case 1:
							System.out.println("Current score is " + score);
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("I'm going to be late!!");
							/*
							 * Screen.this.getTextArea().
							 * setText("Purkis: I'm going to be late to class!!! I never get there on time, "
							 * + "no matter when I wake up!");
							 */
							Main.this.add(purkis);

							// Screen3.this.addMouseListener(
							break;

						case 2:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);

							Main.this.getTextArea().setText("Eric: Are you ready? Steven: No, I'm scared.");
							/*
							 * Screen.this.getTextArea().setText(
							 * "Purkis: Whew! I made it on time… This place always gives me the creeps…" +
							 * "Eric: Hey Purkis! Are you ready for class?" +
							 * "Purkis: No... Our new professor scares me.");
							 */

							Main.this.add(purkis);
							Main.this.add(eric);

							break;

						case 3:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Paul: Pop test time!");
							/*
							 * Screen.this.getTextArea().
							 * setText("Paul: Alright class, we are going to begin" + "\n" +
							 * "by taking a pre-test! Earn more than 30 points to pass." + "\n" +
							 * "You have 20 seconds.");
							 */
							Main.this.add(paul);

							break;

						case 4:
							
							// Creates NoteDrop object to add event to canvas and runs it
							// Control character using left+right arrow keys, catch 30 points within 20 seconds
							// Brains += 2, Bulbs += 1, Cancels -=2
							Main.this.getTextArea().setText("Use the arrow keys to catch lightbulbs and brains for points!");
							background = new Background(nextButtonClickCount);
							NoteDropEvent noteDropEvent = new NoteDropEvent();
							noteDropEvent.setVisible(true);
							Main.this.add(noteDropEvent);
							noteDropEvent.run();
							noteDropEvent.onTimerTick();

							Main.this.add(nextButton);
							break;

						case 5:
							System.out.println("Current score is " + score);
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);

							Main.this.getTextArea().setText("Purkis: I think I did really well!");
							/*
							 * Screen.this.getTextArea().setText(
							 * "Purkis: I think I did really well! But those test questions... " + "\n" +
							 * "They were weird to say the least? I mean, who asks " +
							 * "his students 'when will the terminator arrive?' ");
							 */
							break;

						case 6:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Purkis: It's like some secret encrypted code!");
							break;

						case 7:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Steven: I hope no one finds out about my plan");

							break;

						case 8:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Steven: The world is going to end anyway.");

							break;

						case 9:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Randy: You fool! You will always be nothing!");
							// Screen.this.getTextArea().setText("Randy: Stop laughing so maniacally, you
							// fool! You will always be nothing!");

							break;

						case 10:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Steven: YOU will be a pile of charred dust-- nothing.");

							break;

						case 11:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);

							Main.this.getTextArea().setText("Eric: Did you hear about Randy? Purkis: Uh, no?");
							/*
							 * Screen.this.getTextArea().
							 * setText("Purkis: What a nice night! The cool breeze, the crickets chirping, the distant lights flicking..."
							 * + "\n" + "Eric: Did you hear about Randy being tormented today?");
							 */

							Main.this.add(purkis);
							Main.this.add(eric);

							break;

						case 12:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("I am going to destroy everyone!");
							/*
							 * Screen.this.getTextArea().
							 * setText("Steven: My plan is going to work! I am going to destroy this planet and "
							 * + "everyone who attacked me. I refuse to let anything happen to me!");
							 */
							break;

						case 13:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("My robot is complete. Haha!");
							/*
							 * Screen.this.getTextArea().setText(
							 * "Steven: HAAA! HA--Hahaha... It worked. It's complete. The things that one can do with Java-- "
							 * +
							 * "I have created my robot, my destroyer of all worlds, the means to every end! AHA!"
							 * );
							 */
							break;

						case 14:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Huh? A sticky note?");
							/*
							 * Screen.this.getTextArea()
							 * .setText("Purkis: (next day) Huh? What's this? A sticky note? What does it say?"
							 * + "\n" +
							 * "Note: PLDR- Preliminary Lifeforms Detection Robot, almost complete. Signed Steven."
							 * +
							 * "Wait, what?! There is a trail of bolts and nuts on the ground... Should I be concerned?"
							 * );
							 */
							break;

						case 15:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Collect 3 more clues in 20 seconds!");
							/*
							 * Screen.this.getTextArea().setText(
							 * "Purkis: A dark room. Collect 3 more clues before someone " + "\n" +
							 * "comes in! You hear footsteps 20 seconds away.");
							 */
							break;

						case 16:
							
							// Creates FinderEvent object to add event to canvas and runs it
							// Drag yellow circle across black canvas, must find black rectangle within 20 seconds
							// Rectangle moves randomly after each hit
							
							Main.this.getTextArea().setText("Drag the flashlight around the room until you find something!");
							background = new Background(nextButtonClickCount);
							FinderEvent finderGame = new FinderEvent();
							finderGame.setVisible(true);
							Main.this.add(finderGame);
							finderGame.run();
							finderGame.onTimerTick();
							System.out.println("Current score is " + score);

						case 17:
							System.out.println("Current score is " + score);
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							/*
							 * Screen.this.getTextArea().setText(
							 * "Purkis: I found his blueprints to create an " + "\n" +
							 * "android that only has one task: to kill.");
							 */
							break;

						case 18:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Purkis: I need to tell someone before we all die!");

							break;

						case 19:
							background = new Background(nextButtonClickCount);
							Main.this.add(background);
							Main.this.add(nextButton);
							Main.this.getTextArea().setText("Purkis: WE'RE GOING TO DIE!!");
							Main.this.add(purkis);

							break;

						case 20:
							
							// Three different ending scenes, run based on total points accumulated from events
							
							if (Main.score >= 12) {
								ending1 = new FirstEndingBackground(0);
								Main.this.add(ending1);
								Main.this.add(nextButton);

								Main.this.getTextArea().setText("(EXPLOSION)");

								break;
							} else if (Main.score >= 7) {
								ending2 = new SecondEndingBackground(0);
								Main.this.add(ending2);
								Main.this.add(nextButton);
								Main.this.getTextArea().setText("Steven sneak attacks you.");
								/*
								 * Screen.this.getTextArea().setText("(Steven comes up from behinds)" + "\n" +
								 * "Steven: HAHAHA! No you won't! You will never stop my plan! And you will watch "
								 * + "as I terminated all the people that you know right before your eyes!"); Q
								 */
								break;
							} else {
								ending3 = new ThirdEndingBackground(0);
								Main.this.add(ending3);
								Main.this.getTextArea().setText("Steven kills you privately.");
								/*
								 * Screen.this.getTextArea().
								 * setText("Steven saw you in his secret room, knocked you " +
								 * "unconscious while you ran out the door, dragged you to the library, and killed you "
								 * + "before you could save everyone.");
								 */
								break;
							}

						case 21:

							if (Main.score >= 12) {
								ending1 = new FirstEndingBackground(1);
								Main.this.add(ending1);
								Main.this.getTextArea().setText("Let's build a better world (everyone saved)!");

								break;
							}

							else {
								ending2 = new SecondEndingBackground(1);
								Main.this.add(ending2);
								Main.this.add(nextButton);
								break;
							}

						case 22:
							ending2 = new SecondEndingBackground(2);
							Main.this.add(ending2);
							Main.this.add(nextButton);
							break;

						case 23:
							ending2 = new SecondEndingBackground(3);
							Main.this.add(ending2);
							Main.this.add(nextButton);
							break;

						case 24:
							ending2 = new SecondEndingBackground(4);
							Main.this.add(ending2);
							Main.this.add(nextButton);
							break;

						case 25:
							ending2 = new SecondEndingBackground(5);
							Main.this.add(ending2);
							Main.this.add(nextButton);
							break;

						case 26:
							ending2 = new SecondEndingBackground(6);
							Main.this.add(ending2);
							Main.this.add(nextButton);
							break;

						case 27:
							ending2 = new SecondEndingBackground(7);
							Main.this.add(ending2);
							Main.this.add(nextButton);
							break;

						case 28:
							ending2 = new SecondEndingBackground(8);
							Main.this.add(ending2);
							Main.this.add(nextButton);
							break;

						case 29:
							ending2 = new SecondEndingBackground(9);
							Main.this.add(ending2);
							Main.this.add(nextButton);
							break;

						case 30:
							ending2 = new SecondEndingBackground(10);
							Main.this.add(ending2);
							Main.this.add(nextButton);
							break;

						case 31:
							ending2 = new SecondEndingBackground(11);
							Main.this.add(ending2);

							Main.this.getTextArea().setText("You killed Steven, couldn't save others.");
							/*
							 * Screen.this.getTextArea().
							 * setText("Thinking you were going to die, you somehow managed to kill Steven "
							 * + "before he could kill you, but you couldn't save anyone else.");
							 */
							break;

						default:
							Main.this.removeAll();
							break;

						}

					}

					public void mouseEntered(MouseEvent arg0) {
						nextButton.setColor(Color.RED);
					}

					public void mouseExited(MouseEvent arg0) {
						nextButton.setColor(Color.BLUE);
					}

					public void mousePressed(MouseEvent arg0) {
					}

					public void mouseReleased(MouseEvent arg0) {
					}
				});

		// Adding an actionlistener to the labels so that it can act as a "button" with
		// functionality
		// This button removes everything on the screen and returns canvas back to
		// default, starting canvas.

		backButton.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				Main.this.removeAll();
				Main.this.getTextArea().setText("");
				Main.this.add(background);
				Main.this.add(startButton, (BREADBOARD_WIDTH - startButton.getWidth()) / 2, 300);
				Main.this.add(howToPlayButton, (BREADBOARD_WIDTH - howToPlayButton.getWidth()) / 2, 350);
				Main.this.add(creditsButton, (BREADBOARD_WIDTH - creditsButton.getWidth()) / 2, 400);

			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}

			// Changes color of button to indicate selection
			public void mouseEntered(MouseEvent arg0) {
				backButton.setColor(Color.RED);
			}

			public void mouseExited(MouseEvent arg0) {
				backButton.setColor(Color.BLUE);
			}
		});

		
		// This button begins the program by removing everything on the screen and
		// adding the next frame of the visual novel
		startButton.addMouseListener(
				////////////////////////////////////////////
				new MouseListener() {

					public void mouseClicked(MouseEvent arg0) {
						Main.this.removeAll();

						// Creates WakingUp object and runs it
						// This event, must rapidly click character to wake up within 20 seconds.
						// Click 115 times to wake up.
						Main.this.getTextArea().setText("Wake me up by clicking me repeatedly!");
						WakingUpEvent sleep = new WakingUpEvent();
						sleep.setVisible(true);
						Main.this.add(sleep);
						sleep.run();
						sleep.onTimerTick();

						System.out.println("Current score is " + score);

						Main.this.add(nextButton);

					}

					public void mousePressed(MouseEvent arg0) {
					}

					public void mouseReleased(MouseEvent arg0) {
					}

					public void mouseEntered(MouseEvent arg0) {
						startButton.setColor(Color.RED);
					}

					public void mouseExited(MouseEvent arg0) {
						startButton.setColor(Color.BLUE);
					}
				});

		
		// Implements an action to the howToPlayButton label so that it acts as a
		// "button"
		// Moves to the next frame which shows the instructions

		howToPlayButton.addMouseListener(
				////////////////////////////////////////////
				new MouseListener() {

					public void mouseClicked(MouseEvent arg0) {

						System.out.println("Button was clicked and changed");
						Main.this.removeAll();

						Main.this.getTextArea()
								.setText("Press the 'Start' button to begin the story." + "\n"
										+ "Click through the dialogue and each scene using the left mouse-click." + "\n"
										+ "Some scenes may have interactable events, follow the directions to proceed."
										+ "\n" + "Depending on your performance during the events, this will result in"
										+ "\n" + " different ending outcomes.");
						// howToPlayText.setFont("Arial-PLAIN-12");
						// Screen.this.add(howToPlayText, 0, 300);

						Main.this.add(backButton, 400, 450);
					}

					public void mouseEntered(MouseEvent arg0) {
						howToPlayButton.setColor(Color.RED);
					}

					public void mouseExited(MouseEvent arg0) {
						howToPlayButton.setColor(Color.BLUE);
					}

					public void mousePressed(MouseEvent arg0) {
					}

					public void mouseReleased(MouseEvent arg0) {
					}
				});

		// Implements an action to the creditsButton label so that it acts as a "button"
		// Moves to the next frame which shows the credits

		creditsButton.addMouseListener(
				////////////////////////////////////////////
				new MouseListener() {

					public void mouseClicked(MouseEvent arg0) {

						System.out.println("Button was clicked and changed");

						Main.this.removeAll();
						creditsText = new GLabel("Program created by: " + "\n" + "Steven Chen" + "\n" + "Randy Truong"
								+ "\n" + "Eric Gu" + "\n" + "\n" + "\n" + "Final project for CS_OX 170.");
						creditsText.setFont("Arial-PLAIN-12");
						Main.this.add(creditsText, 0, 300);

						Main.this.add(backButton, 400, 450);

					}

					public void mouseEntered(MouseEvent arg0) {
						creditsButton.setColor(Color.RED);
					}

					public void mouseExited(MouseEvent arg0) {
						creditsButton.setColor(Color.BLUE);
					}

					public void mousePressed(MouseEvent arg0) {
					}

					public void mouseReleased(MouseEvent arg0) {
					}
				});

	}
}
