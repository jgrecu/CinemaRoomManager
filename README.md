# CinemaRoomManager
##About
Cinema has been a part of the entertainment industry for a long time: a good movie is a way to escape reality and live through a variety of emotions. The best cinema experience you can get is probably in a cinema theatre. In this project, you will create an application that helps manage a cinema theatre: sell tickets, check available seats, see sales statistics, and more.

<h2>Description</h2>

<p>Running a cinema theatre is no easy business. To help our friends, let's add statistics to your program. The stats will show the current income, total income, the number of available seats, and the percentage of occupancy. </p>

<p>In addition, our friends asked you to take care of a small inconvenience: it's not good when a user can buy a ticket that has already been purchased by another user. Let's fix this!</p>

<h2>Objectives</h2>

<p>Now your menu should look like this:</p>

<pre><code class="language-no-highlight">1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit</code></pre>

<p>When the item <code class="java">Statistics</code> is chosen, your program should print the following information:</p>

<ul>
	<li>The number of purchased tickets;</li>
	<li>The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;</li>
	<li>Current income;</li>
	<li>The total income that shows how much money the theatre will get if all the tickets are sold.</li>
</ul>

<p>The rest of the menu items should work the same way as before, except the item <code class="java">Buy a ticket</code> shouldn't allow a user to buy a ticket that has already been purchased.</p>

<p>If a user chooses an already taken seat, print <code class="java">That ticket has already been purchased!</code> and ask them to enter different seat coordinates until they pick an available seat. Of course, you shouldn't allow coordinates that are out of bounds. If this happens, print <code class="java">Wrong input!</code> and ask to enter different seat coordinates until the user picks an available seat.</p>

<h2>Examples</h2>

<p>The greater-than symbol followed by a space (<code class="java">&gt; </code>) represents the user input. Note that it's not part of the input.</p>

<pre><code class="language-no-highlight">Enter the number of rows:
&gt; 6
Enter the number of seats in each row:
&gt; 6

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
&gt; 3

Number of purchased tickets: 0
Percentage: 0.00%
Current income: $0
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
&gt; 2

Enter a row number:
&gt; 1
Enter a seat number in that row:
&gt; 1

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
&gt; 3

Number of purchased tickets: 1
Percentage: 2.78%
Current income: $10
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
&gt; 2

Enter a row number:
&gt; 1
Enter a seat number in that row:
&gt; 1

That ticket has already been purchased!

Enter a row number:
&gt; 10
Enter a seat number in that row:
&gt; 20

Wrong input!

Enter a row number:
&gt; 4
Enter a seat number in that row:
&gt; 4

Ticket price: $10

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
&gt; 1

Cinema:
  1 2 3 4 5 6
1 B S S S S S
2 S S S S S S
3 S S S S S S
4 S S S B S S
5 S S S S S S
6 S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
&gt; 3

Number of purchased tickets: 2
Percentage: 5.56%
Current income: $20
Total income: $360

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
&gt; 0
</code></pre>
