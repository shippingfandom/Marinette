;; A script to autosolve corrupt data missions!
;; 
;; A little usage how-to (0.0 )
;; 1. Get an attacking library and place it somewhere in your rkit folder
;; 2. Define library, address and value variables to match your attacking library bounce exploit
;; 3. Run the script with gls [path-to-corrupt-data-bot.gls]


;; Attacking library variables
;; 
;; This is the only thing you must configure for the bot to work!
;; 
;; What is an attacking library?
;; In short, it is a library that gives you a root computer if you pass 
;; local-address as an injection parameter while being inside the same network
;; 
;; The above technique is called "bouncing", and if you have no idea
;; what is bouncing, I highly encourage you to watch the below video by Plu70 <3
;; -> https://youtu.be/I8sjtVxpnvk?si=1PPB-IP7stmm0ONZ <-
;; 
;; Where to get an attacking library?
;; The easiest way to get an attacking library is to download it from other players websites,
;; for example, www.celestial.com
;; 
;; Always be cautious and carefull when you visit players websites! Proxy usage is highly adviced!
;; 
;; Step by step instruction for www.celestial.com, assuming you are on the main page:
;; 1. Click on "Libs" button and scroll to the bottom. You will see the Poison Libs. That's the
;; attacking libraries available for you too choose from. Remember the name and version
;; 2. Scroll back up and click on "Files". Find and download the library you have remembered
;; 3. Copy the library to your rkit and to /lib folders and run this line (without |>):
;; |> meta load /lib/attackinglibrary.so | db -m || zap -l
;; 4. Copy address and value of the root computer exploit to the below.
;; Hooray! The bot is configured! \(^.^)/
(def library 'libhttp-1.0.4.so')
(def address '0x7DD8F3DE')
(def value 'alse')

;; Open mail client and dump spool
((|> mail))
(def spool ((|> grep) '-f' '^spool.txt$'))
(def library-file ((|> grep) '-f' (join (array '^' library '$') '')))

;; If we forgot to dump spool, exit
(if (!= 'file' (typeof spool))
    'corrupt-data-bot.gls: Please dump spool file!'

;; Else if we did not download a library on our computer before running the bot
(if (!= 'file' (typeof library-file))
    'corrupt-data-bot.gls: Please download an attacking library!'

;; Else continue
(begin
    ;; Silence the output of any commands 5hell evaluates
    ;; Does not affect Marinette specific commands!
    (def silent-state (: SILENT))
    (:= SILENT 2)

    (gl-break-silence 'Reading spool file...')
    (def path ((|> file) '-p' spool))
    (def content ((|> cat) path))
    ((|> rm) path)

    (gl-break-silence 'Loading hash tables...')
    ((|> cerebrum))

    (gl-break-silence 'Going through every email...')
    (def offset 0)
    (while (!= null offset) (begin
        (def left (indexOf content '<b>'))
        (if (== null left) (begin
            (def offset null)
            (gl-break-silence 'Completed solving corrupt data missions!'))

        (begin
            ;; Get public address
            (def left (+ (len '<b>') (indexOf content '<b>')))
            (def right (indexOf content '</b>'))

            (def public-address (slice content left right))

            (def offset (+ right (len '</b>')))
            (def content (slice content offset (len content)))

            ;; Get local address
            (def left (+ (len '<b>') (indexOf content '<b>')))
            (def right (indexOf content '</b>'))

            (def local-address (slice content left right))

            (def offset (+ right (len '</b>')))
            (def content (slice content offset (len content)))

            (gl-break-silence (join (array 'Hacking the router at ' public-address '...') ''))
            ((|> nemesis) public-address '0' local-address)

            ;; Get all guest+ shells
            (def tws ((|> tws) 's' 'pl'))

            ;; Find the router shell by going through each line of TWS in a foreach loop
            (def lines (split tws (char 10)))
            (foreach _ line lines (begin
                (def shell-index (to_int (slice line (+ 1 (indexOf line '[')) (indexOf line ']'))))
                (def tws-public-address (slice line (+ 1 (indexOf line '@')) (indexOf line '/')))

                ;; It seems you can't bounce from the outside of the network
                ;; So if the public address match our target, this is the router! \(^.^ \)
                (if (== tws-public-address public-address) (begin
                    ;; Get router shell from BUFFER
                    (def shell (at ((|> bios) '-B') shell-index))

                    ;; Ghost infiltrate shell router
                    ;; You can avoid ghost infiltrating if you want, it's not PvP
                    ;; I use it here because I'm used to it!
                    ;; You know, just using the toolset I have popping in my head
                    (def infil-path ((|> infil) '-g' shell))

                    ;; Find an attacking library on the infiltrated router
                    (def library-path ((|> grep) '-p' (join (array '^' library '$') '') shell))

                    ;; Construct arguments for 5hell before running her on infiltrated router
                    (def run-args (join (array
                        ;; Silence the output for 5hell on router
                        'kore --silent'
                        ;; Brute and save root shell, upload library from guest shell to root shell
                        (join (array 'brutus | clipc | scpm -u ' library-path ' /lib/') '')
                        ;; Load library
                        (join (array 'meta load /lib/' library) '')
                        ;; Bounce to local address we need and corrupt the machine behind it
                        (join (array 'zap ' address ' ' value ' ' local-address ' | sc -n') '')
                        ;; Undercover the router just to be safe
                        (join (array 'clipc | undercover') '')
                        ;; Break the silence
                        'kore --silent'
                        ;; Close 5hell on router
                        'close')
                        ' | | '))

                    ;; And everything works like magic! Hooray! \(^.^)/
                    (gl-break-silence (join (array 'Corrupting ' public-address ':' local-address '...') ''))
                    ((|> run) infil-path run-args shell)))))))))

    ;; Break the silence! <3
    (:= SILENT silent-state))))
