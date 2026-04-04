# Marinette
![Marinette.png](images/Marinette.png)

A set of [5hell](https://github.com/jhook777/5hell-for-Grey-Hack-the-Game) configuration files written entirely in [Glosure](https://github.com/mahocitrus/Glosure)!

**TL;DR** An [installation how-to](#okay-you-definitely-bought-me-how-can-i-install-marinette) for those who can't wait! 👀

## What is even this?
It's **Marinette** - the addition to your **5hell**'s **rkit/do.rc**, written entirely in **Glosure**! 😜

## Why Marinette?
**Marinette** is named in honor of [Marinette Dupain-Cheng](https://en.wikipedia.org/wiki/Marinette_Dupain-Cheng), my favourite character of the [Miraculous: Tales of Ladybug & Cat Noir](https://en.wikipedia.org/wiki/Miraculous:_Tales_of_Ladybug_%26_Cat_Noir) series! 🐞

## What is 5hell?
**5hell** is an awesome shell emulator and multitool by the fabulous [Plu70](https://github.com/jhook777), which you can use and tinker on for *absolutely* free! 🎁

## What is rkit/do.rc?
It's like **.bashrc**, but for **5hell**!

If you have absolutely no idea what **.bashrc** is, not a single clue about how **do.rc** works and don't feel like reading through a whole lot, no worries! 🤭

In simple words, **do.rc** is simply a file with a set of commands that gets executes every time you launch **5hell** 🧾

If you would like to learn more in detail about how it works, refer to the documentation [here](https://github.com/Arc8ne/5hell-Documentation-Extractor/blob/main/5hell-Documentation.md#do), or simply issue `help -s do.rc` command while running the **5hell** herself 🥰

## What and why Glosure?
**Glosure** is the first ever publicly available interpreted lisp-like language for **Grey Hack** by the gorgeous [mahocitrus](https://github.com/mahocitrus), which **5hell** supports fully and without *any* restrictions! 😃

It allows everything **do.rc** scripitng allows *plus* everything in-game **scripting** allows! Which opens endless possibilities with what you can implement in a configuration files, really! 🌺

## Do I need to know Glosure to use this?
Absolutely no! **Marinette** doesn't require any **Glosure** knowledge for you to use her. However, if you want to modify something or write your own **Glosure** scripts, you, of course, would make use of **Glosure** 😉

## How can I write my own scripts or modify the config?
For now, you can write your own script only by reading the [Glosure tutorial](https://github.com/mahocitrus/Glosure/blob/main/Tutorial.md) and checking the [scripts in bonus](bonus)

However, modifying **do.gls** is as easy as just commenting out something or simply following the instructions in the comments!

## Why would I want to use Marinette?
Because just as **5hell**, **Marinette** is *completely* free to use and to tinker on! 💅

Not only that, but **Marinette**:
- Adds many usefull commands and macros 🖥
- Adds support for themes 🌼
- Is easy to install and use ☘️
- Is fully compatible with the **do.rc** you already have 👀
- Loves all of you! 💝

## Okay, you definitely bought me! How can I install Marinette?
Awesome! Can't wait for it! 😄

To install **Marinette**, follow these simple instructions:

1. Ensure you have **rkit/do.rc** file. If you haven't, issue `kore -r`. Skip tables generation as it will make the process A LOT longer! ⏳
2. Add [these simple lines](do.rc) at the end of **do.rc** 📝
3. Close **5hell** and run her again. This will generate **marinette** folder structure in your **rkit** 🗂
4. Go to **rkit/marinette/glosure** and paste in [5hell.gls](glosure/5hell.clj), [do.gls](glosure/do.clj), [marinette.gls](glosure/marinette.clj), one by one ✏️
5. Close **5hell** and run her again 💻

Congratulatuons, **Marinette** is successfully installed! 💞

Now you may would want to do one of the following things:
- Issue `help -s Marinette` to see what commands were added or changed 💾
- Issue `macros` to see what macros were added 📼
- Change 5hell theme. Read themeing section in **rkit/marinette/glosure/do.gls** and choose a theme from [themes](themes) 🏁

Happy hacking! 👾

## Doesn't sound convincing... Maybe I'll try it later...
No worries! And thanks for reading this far 😌

I still encourage you to check out [these projects](#the-people-who-made-this-possible), though!

## I've encountered a bug, please help!
Absolutely try these easy steps before reporting ✌️
1. Rename all binaries with the name **5hell** to something else, for example, 5hell.bak, or remove them from the machine entirely 🔍
2. Rename all folders with the name **rkit** to something else, for example, rkit.bak, or remove them from the machine entirely 📝
3. Build the most recent **5hell** from the [upstream](https://github.com/jhook777/5hell-for-Grey-Hack-the-Game) ✨
4. Create **rkit** folder in /root and create **do.rc** text file in it 📄
5. Begin the [installation](#okay-you-definitely-bought-me-how-can-i-install-marinette) of **Marinette** <u>from the step 2!!!</u>

If the issue is resolved, chances are high that this has something to do with your setup! 😔

Update your **5hell** on **home**, in **rkit**, on **HOME server**, on the targets you are attacking, and then do the same with **Marinette**! 

The issue is still there? I will be more than happy if you tell me about it in the DM (my ID is `not_s0phie`) or the **5hell** official [discord server](https://discord.gg/VuWYdWUXQw)

## Why there are SO many whys and whats?
Well, it's just because I felt like writing an entire novel in a single README file. Whoops!

I'm absolutely sure something is still missing in here... Guess we'll see! 😅

## The people who made this possible!
**Marinette** wouldn't be possible without you! Big thanks to *all* of you! 💖

- Thanks [Plu70](https://github.com/jhook777) for [5hell](https://github.com/jhook777/5hell-for-Grey-Hack-the-Game)!
- Thanks [mahocitrus](https://github.com/mahocitrus) for [Glosure](https://github.com/mahocitrus/Glosure)!
- Thanks [Arc8ne](https://github.com/Arc8ne) for the [extracted documentation](https://github.com/Arc8ne/5hell-Documentation-Extractor/blob/main/5hell-Documentation.md)!

You all are simply the best! 🥰

## Afterword

I could forget to mention someone above, something can be broken, some link in the repository may lead to rickroll, all that thingies I overlooked, so if you find out something I can fix or help you with please let me know in the Discord (my ID is `not_s0phie`)! Thanks for your patience and for using this little project of mine! Lots of loooove! 💕
