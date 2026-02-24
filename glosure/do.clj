(mari-mkdir 'themes')       ;; rkit/marinette/themes
(mari-mkdir 'glosure')      ;; rkit/marinette/glosure
(mari-mkdir 'binaries')     ;; rkit/marinette/binaries
(mari-mkdir 'notepads')     ;; rkit/marinette/notepads




;; 
;; Macros
;; 
(>> cls @pipe
    ((|> clear) (# @pipe 0 '')))

(>> nslookup @pipe
    ((|> nsl) (# @pipe 0 '')))

(>> buf @pipe (begin
    (def a1 (# @pipe 0))
    (if (!= null (indexOf (array '-h' 'help') a1))
        ((|> malp) '-h')
        ((|> malp) '-b'))))

(>> close @pipe (begin
    (def a1 (# @pipe 0))
    (if (!= null (indexOf (array '-h' 'help') a1))
        ((|> quit) '-h')
        ((|> quit) 'Thanks for using Marinette! See you soon <3'))))

(>> macros @pipe (begin
    (def a1 (# @pipe 0))
    (if (!= null (indexOf (array '-h' 'help') a1))
        ((|> macro) '-h')
        ((|> macro) '-l'))))

(>> unlock @pipe (begin
    (def input (# @pipe 0 ''))
    (if (== '' input) (begin
        (gl-break-silence 'Warning: this will run the following on the object you are in!')
        (gl-break-silence '<b>usr -r guest / || grp -r guest / || perms unlock all</b>')
        (gl-break-silence 'Continue? (N/y)')
        (def input (lower (user_input '||: ' 0 1 0)))))
    (if (== 'y' input) (begin
        ((|> usr) '-r' 'guest' '/')
        ((|> grp) '-r' 'guest' '/')
        ((|> perms) 'unlock' 'all'))
    (begin
        'Aborting...'))))

(>> gls @pipe (begin
    (def path (# @pipe 0 ''))
    (if (== '' path)
        'gls: a path to the glosure script is needed.'
    (begin
        ((|> glosure) '-e' ((|> cat) path))))))


;; 
;; Aliases
;; 
(|= touch (a1 a2 a3 a4)
    ((|> poke) a1 a2 a3 a4))

(|= del (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        ((|> rm) '-h' a2 a3 a4)
        ((|> rm) '-r' a1 a2 a3)))

(|= nmap (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        ((|> probe) '-h' a2 a3 a4)
    (if (!= null (indexOf (array '-s' 'show') a1))
        ((|> probe) '-s' a2 a3 a4)
    (begin
        ((|> probe) '-f' a1 a2 a3)))))

(|= dir (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        ((|> ls) '-h')
        ((|> ls) '-la' a1 a2 a3)))

(|= su (a1 a2 a3 a4) (begin
    (def shell
        (if (!= null (indexOf (array '-h' 'help') a1))
            ((|> psudo) '-h' a2 a3 a4)
        (if (== '-s' a1)
            ((|> psudo) '-n' a2 a3 a4)
        (if (== '-u' a1)
            ((|> psudo) '-u' a2 a3 a4)
        (begin
            (((|> psudo) a1 a2 a3 a4)))))))
    (if (== 'shell' (typeof shell))
        ((|> glasspool) shell)
        shell)))


;; 
;; Commands
;; 
(|= match (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help' 0) a1))
        (join (array
            '<u>Marinette || pattern matching || regular expressions || re</u>'
            ''
            '<b>Usage: match [pattern] [string]</b> -- Match regular expression patterns'
            '--eg: <b>match " hello " " hello world! " </b> -- Prints and returns 1'
            'Refer to <b>netstalk -h</b> for more examples!'
            ''
            '<u>Basic regular expressions</u>'
            '-- <b>.*</b> -- matches any amount of characters between two words(including none)'
            '-- <b>\</b> -- is used to escape regexp building characters(e.g. dot)'
            '-- <b>SomeWord</b> -- matches SomeWord substring in the string'
            ''
            '<u>A note about supported regular expressions</u>'
            'All of the pattern matching is being done by string.is_match() function!'
            'Therefore probably everything you expect will work (but test beforehand!)')
            (char 10))
    (if (+ (!= 'string' (typeof a1)) (!= 'string' (typeof a2)))
        (join (array
            'match: need two string arguments.'
            'See <b>match -h</b> for more info!')
            (char 10))
    (begin
        ((_ a2 is_match) a2 a1)))))

(|= netstalk (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help' 0) a1))
        (join (array
            '<u>Marinette || netstalking || randomstalking || delisearch || service finder</u>'
            ''
            '<b>Usage: netstalk [pattern]</b> -- Probe random networks with regular expression patterns'
            '-- generates random network address'
            '-- probes for its portmap'
            '-- applies regexp pattern matching'
            '-- if the pattern matches, returns the address'
            '-- else continues until the pattern matches on some random address'
            '--eg: <b>netstalk ssh</b> -- matches for a network with ssh service onboard'
            '--eg: <b>netstalk gateway.*1\.2\.3</b> -- matches for a network with a gateway router version 1.2.3'
            '--eg: <b>netstalk open.*ftp</b> -- matches for a network with publicly opened ftp port'
            '--eg: <b>netstalk internal.*smtp.*1\.2\.3</b> -- matches for a network with an internal smtp version 1.2.3 port'
            ''
            'For more info on regular expressions, see <b>match -h</b>')
            (char 10))
    (if (!= 'string' (typeof a1))
        (join (array
            'netstalk: pattern must be a string.'
            'See <b>netstalk -h</b> for more info!')
            (char 10))
    (if (== 0 ((_ (: localmachine) is_network_active) (: localmachine)))
        'netstalk: no network connection.'
    (begin
        (def silent-state (: SILENT))
        (:= SILENT 2)
        (do-while not-have-found (begin
            (def rnip ((|> rnip) '1'))
            (gl-break-silence (join (array 'Matching ' a1 ' on ' rnip '...') ''))
            ((|> probe) '-q' rnip)
            (def probe ((|> probe) '-s'))
            (def not-have-found (== 0 (match a1 probe)))))
        (:= SILENT silent-state)
        (gl-break-silence (join (array 'Found ' rnip ' matching ' a1 ' <3') ''))
        rnip)))))

(|= type (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            '<u>Marinette || typeof || get object type</u>'
            ''
            '<b>Usage: type [object]</b> -- Get the type of the passed object'
            '--eg: <b>echo Hi! | type</b> -- Will print you a string')
            (char 10))
    (begin
        (typeof a1))))

(|= nemesis (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            '<u>Marinette || hacking utility || roil the database</u>'
            ''
            '<b>Usage: nemesis [opt:ip] [opt:port] [opt:inject]</b> -- Hack remotely using database'
            '--eg: <b>nemesis 1.1.1.1 0</b> -- Attempt to linkdb against the said gateway and will roil in case of success, else db'
            '--eg: <b>target 1.1.1.1 0 || nemesis</b> -- You can use predefined target!')
            (char 10))
    (begin
        (def silent-state (: SILENT))
        (:= SILENT 2)
        (def address (if (!= 0 a1) a1 ((|> target) 'ip')))
        (def port (if (!= 0 a2) a2 (str ((|> target) 'pt'))))
        (:= SILENT silent-state)
        (def inject a3)
        (if (!= null (indexOf (array 0 null) address))
            (join (array
                'nemesis: at least an address must be specified.'
                'See <b>nemesis -h</b> for more info!')
                (char 10))
        (if (== 0 ((_ (: localmachine) is_network_active) (: localmachine)))
            'nemesis: no network connection.'
        (begin
            ;; Setting the target
            (def silent-state (: SILENT))
            (:= SILENT 2)
            ((|> target) address port)
            (def metalib ((|> meta) 'link'))
            ;; Getting the database entry
            (def target-lib ((|> liber) metalib))
            (def is-linked (== 0 ((|> linkdb) target-lib '-y')))
            (:= SILENT silent-state)
            (if (== 1 is-linked)
                ;; Use the entry in case it's found
                ((|> roil) inject)
            (begin
                ;; Do the magic otherwise
                ;; 1. Swap metaxploit to myx0
                (def silent-state (: SILENT))
                (:= SILENT 2)
                (def link-metaxploit ((|> meta) '-x'))
                (def hack-metaxploit ((|> cob) 'get' 'myx0'))
                ((|> meta) '-i' hack-metaxploit)
                (:= SILENT silent-state)
                ;; 2. Proceed with hacking
                (def return-value ((|> db) '-m' metalib inject))
                ;; 3. Swap back to what was used before the swap
                (def silent-state (: SILENT))
                (:= SILENT 2)
                ((|> meta) '-i' link-metaxploit)
                (:= SILENT silent-state)
                return-value))))))))

(|= undercover (a1 a2 a3 a4) (begin
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            '<u>Marinette || under the cover || cover your traces</u>'
            ''
            '<b>Usage: undercover [opt:shell|computer]</b> -- Cover your traces you have made with ghost infiltrating'
            '--eg: <b>brutus | undercover</b> -- Attempts to bruteforce the password and then covers the traces left')
            (char 10))
    (begin
        (def files ((|> grep) '-a' '^rkit$' a1 a2))
        (if (== 'list' (typeof files))
            (foreach _ file files (begin
                (def parent ((_ file parent) file))
                (def parent-name ((_ parent name) parent))
                (def parent-path ((_ parent path) parent))
                (if (== 0 (indexOf parent-name '\.'))
                    (if (== '' ((_ parent delete) parent))
                        (gl-break-silence (join (array 'Deleted ' parent-path ' ...') ''))
                        (gl-break-silence (join (array 'Could not delete ' parent-path '!') '')))))))
        (if (== 1 ((|> silentclean) '-d' a1 a2 a3))
            'Successfully covered traces with silentclean -d <3'
            'Could not cover traces with silentclean -d! </3')))))

(|= hashcat (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help' 0) a1))
        (join (array
            '<u>Marinette || hash cracker || decipher tool</u>'
            ''
            '<b>Usage: hashcat [/path/to/file|file_object|hash_string|hash_list|@tbuf]</b> -- Crack the hash using gopher'
            'The only difference from gopher is it uses host crypto.so instead of the loaded one ^.^'
            'See <b>gopher -h</b> for more info about gopher!')
            (char 10))
    (begin
        ;; Swap crypto to myc0
        (def silent-state (: SILENT))
        (:= SILENT 2)
        (def current-crypto ((|> bios) '-c'))
        (def host-crypto ((|> cob) 'get' 'myc0'))
        ((|> bios) '-C' host-crypto)
        (:= SILENT silent-state)
        ;; Proceed with hashcracking
        (def return-value ((|> gopher) a1 a2 a3 a4))
        ;; Swap back to what was used before the swap
        (def silent-state (: SILENT))
        (:= SILENT 2)
        ((|> bios) '-C' current-crypto)
        (:= SILENT silent-state)
        return-value)))

(|= breach (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help' 0) a1))
        (join (array
            '<u>Marinette || breach the network || bypass firewall </u>'
            ''
            '<b>Usage: breach [memory] [value]</b> -- Disable firewall in the entire local network')
            (char 10))
    (if (== 0 a2)
        (join (array
                'breach: both memory and value must be specified.'
                'See <b>breach -h</b> for more info!')
                (char 10))
    (if (== 0 ((_ (: localmachine) is_network_active) (: localmachine)))
        'breach: no network connection.'
    (begin
        (def silent-state (: SILENT))
        (:= SILENT 2)
        (gl-break-silence 'Scanning the local network...')
        (def lanpro ((|> lanpro)))
        ((|> porter) '0' lanpro)
        (def lines (split ((|> clipb)) (char 10)))
        (foreach _ line lines (begin
            (def address (pull (split line ' ')))
            (gl-break-silence (join (array 'Disabling the firewall for ' address '...') ''))
            ((|> target) address '0')
            ((|> meta) 'link')
            ((|> zap) a1 a2)))
        (:= SILENT silent-state)
        null)))))


;; 
;; Hooks
;; 
(def INFIL (|> infil))
(|= infil (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            (INFIL '-h' a2 a3 a4)
            ''
            '<u>Marinette specific functionality</u>'
            'You can now infiltrate a target with your rkit folder uploading hidden!'
            'Moreover, it uploads to any available permissive folder it finds, not necessarily /home/guest'
            'To perform this kind of infiltration, issue <b>infil -g/ghost [shell_object]</b>'
            'To run 5hell after infiltration, use <b>-G</b> flag')
            (char 10))
    (if (!= null (indexOf (array '-g' 'ghost') (lower a1))) (begin
        (def shell a2)
        (if (!= 'shell' (typeof a2))
            (join (array
                'infil: second argument must be a shell.'
                'See <b>infil -h</b> for more info!')
                (char 10))
        (begin
            (def infil-folder (mari-mkdir-hidden-infil ((_ shell host_computer) shell)))
            (def rkit (gl-grep-into (array '^rkit$')))
            (if (!= 'file' (typeof infil-folder))
                'infil: target could not be infiltrated silently.'
            (if (!= 'file' (typeof rkit))
                'infil: no rkit found on the host.'
            (begin
                (def rkit-path ((_ rkit path) rkit))
                (def upload-path ((_ infil-folder path) infil-folder))
                ;; Unlocking 5hell
                ((|> usr) '-r' 'guest' rkit-path)
                ((|> grp) '-r' 'guest' rkit-path)
                ((|> perms) '-r' 'o+rwx' rkit-path)
                ((|> perms) '-r' 'g+rwx' rkit-path)
                ((|> perms) '-r' 'u+rwx' rkit-path)
                ;; Uploading unlocked 5hell
                ((|> scpm) '-u' rkit-path upload-path shell)
                ;; Locking back
                ((|> usr) '-r' 'root' rkit-path)
                ((|> grp) '-r' 'root' rkit-path)
                ((|> perms) 'lock' rkit-path)
                ;; Yielding 5hell on target
                (def five-hell-path (gl-pathcat (array upload-path 'rkit' '5hell')))
                (gl-break-silence (join (array '5hell is accessible at ' five-hell-path '! <3') ''))
                (if (== '-G' a1)
                    ((|> run) five-hell-path shell)
                    five-hell-path)))))))
    (begin
        (INFIL a1 a2 a3 a4)))))

(def KRAKEN (|> kraken))
(|= kraken (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            (KRAKEN '-h' a2 a3 a4)
            ''
            '<u>Marinette specific functionality</u>'
            'Hack random NPCs and populate Map.conf with their machines'
            '--eg: <b>kraken -r/random [count]</b>')
            (char 10))
    (if (!= null (indexOf (array '-r' 'random') a1))
        (if (+ (== 0 a2) (!= 'number' (typeof (to_int a2))))
            (join (array
                'kraken: second argument must be a positive integer.'
                'See <b>kraken -h</b> for more info!')
                (char 10))
        (if (== 0 ((_ (: localmachine) is_network_active) (: localmachine)))
            'kraken: no network connection.'
        (begin
            (def silent-state (: SILENT))
            (:= SILENT 2)
            (gl-break-silence 'Loading hash tables...')
            ((|> cerebrum))
            (gl-break-silence 'Looking for NPC machines...')
            (def faulty-machines (array))
            (def addresses-generated 0)
            (def count (to_int a2))
            (while (> count 0) (begin
                (if (* (>= addresses-generated 5) (== 0 (% addresses-generated 5)))
                    (gl-break-silence (join (array 'Have tried ' addresses-generated ' addresses so far...') '')))
                (def rnip ((|> rnip) '1'))
                (++ addresses-generated)
                ((|> probe) '-q')
                (def probe ((|> probe) '-s'))
                (def has-smtp (== rnip ((|> porter) '25' rnip)))
                (def has-ssh (== rnip ((|> porter) '22' rnip)))
                (def is-npc-network (* has-smtp has-ssh))
                (if (== 1 is-npc-network) (begin
                    (gl-break-silence (join (array 'Hacking ' rnip ' on port 22...') ''))
                    (nemesis rnip '22')
                    (def tws ((|> tws) 's' 'pl'))
                    (def lines (split tws (char 10)))
                    (def is-bruted 0)
                    (foreach _ line lines (begin
                        (def shell-index (to_int (slice line (+ 1 (indexOf line '[')) (indexOf line ']'))))
                        (def public-address (to_int (slice line (+ 1 (indexOf line '@')) (indexOf line '/'))))
                        (def local-address (to_int (slice line (+ 1 (indexOf line '/')) (len line))))
                        (if (* (== 0 is-bruted) (* (!= 0 shell-index) (== rnip public-address))) (begin
                            (def shell (at ((|> bios) '-B') shell-index))
                            (def five-hell (infil '-g' shell))
                            ((|> run) five-hell 'kore --silent || brutus | undercover || kore --silent || return y' shell)
                            (def lookup-addresses (join (array public-address ':' local-address) ''))
                            (foreach key value (get_custom_object)
                                (if (* (== 0 is-bruted) (== lookup-addresses value)) (begin
                                    (KRAKEN 'add' rnip key)
                                    (gl-break-silence (join (array 'Added root@' key ' ' rnip ' 22 to Map.conf!') ''))
                                    (-- count)
                                    (def is-bruted 1))))))))
                    (if (== 0 is-bruted)
                        (push faulty-machines rnip))))))
            (:= SILENT silent-state)
            (gl-break-silence (join (array 'A total of ' a2 ' NPC machines have been added to Map.conf!') ''))
            (if (!= 0 (len faulty-machines)) (begin
                (gl-break-silence 'Warning: these machines could not be rooted and you absolutely must root them and cover your traces yourself!')
                (gl-break-silence (join faulty-machines ', '))))
            'Note: it is adviced to run <b>kraken scrub</b> to avoid detection!')))
    (begin
        (KRAKEN a1 a2 a3 a4)))))

;; Repository updating workaround
(def APTM (|> aptm))
(|= aptm (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            (APTM '-h' a2 a3 a4)
            ''
            '<u>Marinette specific functionality</u>'
            'You can now force update repositories using <b>aptm -U/update</b>')
            (char 10))
    (if (!= null (indexOf (array '-U' 'update') a1))
        ((|> aptm) '-u' (gl-random-string 16))
    (begin
        (APTM a1 a2 a3 a4)))))

(def RUN (|> run))
(|= run (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            (RUN '-h' a2 a3 a4)
            ''
            '<u>Marinette specific functionality</u>'
            'You can now specify shell as the first argument!')
            (char 10))
    (if (* (== 'shell' (typeof a1)) (== 'string' (typeof a2)))
        (if (== 0 a3)
            (RUN a2 a1 a3 a4)
            (RUN a2 a3 a1 a4))
    (begin
        (RUN a1 a2 a3 a4)))))

(def ZAP (|> zap))
(|= zap (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            (ZAP '-h' a2 a3 a4)
            ''
            '<u>Marinette specific functionality</u>'
            'You can now quickly get a list of available exploits without opening up a menu with <b>zap -l/list</b>!')
            (char 10))
    (if (!= null (indexOf (array '-l' 'list') a1))
        (ZAP '-r' '1337')
    (begin
        (ZAP a1 a2 a3 a4)))))

(def ZC (|> zc))
(|= zc (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            (ZC '-h' a2 a3 a4)
            ''
            '<u>Marinette specific functionality</u>'
            '<b>zc -i/info [path_to_lib_or_folder]</b> -- Print patch state of local libraries'
            ''
            '<b>zc -e/enum [address]</b> -- Enumerate remote libraries and print info about them'
            '-- This action leaves logs on the remote machine!'
            ''
            '<b>zc -p/patch [user] [password] [path_to_lib_or_folder]</b> -- Auto-patch local libraries'
            '-- This action removes any orig and patch.zd it finds!'
            '-- It is highly adviced to remove any debugLibraries from your BUFFER before using this!'
            '-- As of Marinette config v0.0.3 this feature is still quite untested so proceed at your own risk')
            (char 10))
    (if (!= null (indexOf (array '-i' 'info') a1)) (begin
        (def file ((|> file) '-r' a2))
        (if (!= 'file' (typeof file))
            (join (array
                'zc: second argument must be a path to the existing file.'
                'See <b>zc -h</b> for more info!')
                (char 10))
        (begin
            (def silent-state (: SILENT))
            (:= SILENT 2)
            (def info (array))
            (def files
                (if (== 1 ((_ file is_folder) file))
                    ((_ file get_files) file)
                    (array file)))
            (while (> (len files) 0) (begin
                (def file (pull files))
                (def path ((_ file path) file))
                (def metalib ((|> meta) 'load' path))
                (if (== 'MetaLib' (typeof metalib))
                    (push info (join (array
                        ((_ metalib lib_name) metalib)
                        ((_ metalib version) metalib)
                        (if (== 1 ((_ metalib is_patched) metalib))
                            'patched'
                            'unpatched')
                        ((_ metalib is_patched) metalib 1)
                        ) ' ')))))
            (:= SILENT silent-state)
            (if (> (len info) 0)
                (+ (char 10) (format_columns (join (+ (array 'LIBRARY VERSION STATUS DATE') info) (char 10))))))))
    (if (!= null (indexOf (array '-e' 'enum') a1)) (begin
        (if (== 0 ((_ (: localmachine) is_network_active) (: localmachine)))
            'zc: no network connection.'
        (begin
            (def router
                (if (== 'router' (typeof (get_router a2)))
                    (get_router a2)
                    (get_switch a2)))
            (if (!= 'router' (typeof router))
                (join (array
                    'zc: incorrect address.'
                    'See <b>zc -h</b> for more info!')
                    (char 10))
            (begin
                (def silent-state (: SILENT))
                (:= SILENT 2)
                (def info (array 'PORT STATUS LIBRARY VERSION DATE ADDRESS'))
                (def ports ((_ router used_ports) router))
                (for (def i 0) (< i (len ports)) (++ i)
                    (set ports i (str ((_ (at ports i) port_number) (at ports i)))))
                (def ports (+ (array '0') ports))
                (foreach _ port ports (begin
                    ((|> target) a2 port)
                    (def metalib ((|> meta) 'link'))
                    (def local-address
                        (if (== '0' port)
                            ((_ router local_ip) router)
                        (begin
                            (def pinged-port ((_ router ping_port) router (to_int port)))
                            ((_ pinged-port get_lan_ip) pinged-port))))
                    (if (!= 'MetaLib' (typeof metalib))
                        (push info (join (array
                            (if (== '0' port)
                                a2
                                port)
                            'undetermined'
                            ((_ metalib lib_name) metalib)
                            ((_ metalib version) metalib)
                            'undetermined'
                            local-address) ' '))
                        (push info (join (array
                            (if (== '0' port)
                                a2
                                port)
                            (if (== 1 ((_ metalib is_patched) metalib))
                                'patched'
                                'unpatched')
                            ((_ metalib lib_name) metalib)
                            ((_ metalib version) metalib)
                            ((_ metalib is_patched) metalib 1)
                            local-address) ' ')))))
                (:= SILENT silent-state)
                (format_columns (join info (char 10))))))))
    (if (!= null (indexOf (array '-p' 'patch') a1)) (begin
        (if (+ (!= 'string' (typeof a4)) (+ (!= 'string' (typeof a2)) (!= 'string' (typeof a3))))
            (join (array
                'zc: must provide credentials and path.'
                'See <b>zc -h</b> for more info!')
                (char 10))
        (begin
            (def file ((|> file) '-r' a4))
            (if (!= 'file' (typeof file))
                (join (array
                    'zc: fourth argument must be a path to the existing file.'
                    'See <b>zc -h</b> for more info!')
                    (char 10))
            (begin
                (def silent-state (: SILENT))
                (:= SILENT 2)
                (def return null)
                (def info (array))
                (def files
                    (if (== 1 ((_ file is_folder) file))
                        ((_ file get_files) file)
                        (array file)))
                (while (> (len files) 0) (begin
                    (def file (pull files))
                    (def path ((_ file path) file))
                    (def metalib ((|> meta) 'load' path))
                    (if (== 'MetaLib' (typeof metalib)) (begin
                        (def origs ((|> grep) '-a' '^orig$'))
                        (if (== 'list' (typeof origs))
                            (foreach _ orig-file origs
                                ((|> del) ((_ orig-file path) orig-file))))
                        (def patchzds ((|> grep) '-a' '^patch.zd$'))
                        (if (== 'list' (typeof patchzds))
                            (foreach _ patch-file patchzds
                                ((|> del) ((_ patch-file path) patch-file))))
                        (def zerochill (ZC a2 a3 metalib))
                        (if (== 1 (len (split zerochill (char 10))))
                            (def return zerochill)
                        (begin
                            (def debug-library (mari-buffer-top-debug-library))
                            (if (!= 'debugLibrary' (typeof debug-library)) (begin
                                (def files (array))
                                (def return (join (array
                                    'zc: incorrect credentials.'
                                    'See <b>zc -h</b> for more info!')
                                    (char 10))))
                            (begin
                                (def result ((_ debug-library apply_patch) debug-library ((|> grep) '-p' '^patch.zd$')))
                                (gl-break-silence (join (array 'Patching status for ' path ' -- ' result) ''))))))))))
                (def origs ((|> grep) '-a' '^orig$'))
                (if (== 'list' (typeof origs))
                    (foreach _ orig-file origs
                        ((|> del) ((_ orig-file path) orig-file))))
                (def patchzds ((|> grep) '-a' '^patch.zd$'))
                (if (== 'list' (typeof patchzds))
                    (foreach _ patch-file patchzds
                        ((|> del) ((_ patch-file path) patch-file))))
                (:= SILENT silent-state)
                return)))))
    (begin
        (ZC a1 a2 a3 a4)))))))

(def PROX (|> prox))
(|= prox (a1 a2 a3 a4)
    (if (!= null (indexOf (array '-h' 'help') a1))
        (join (array
            (PROX '-h' a2 a3 a4)
            ''
            '<u>Marinette specific functionality</u>'
            'You can now open 5hell instead of a terminal with <b>prox -g/ghost</b>!'
            'This will run scrub beforehand!')
            (char 10))
    (if (!= null (indexOf (array '-g' 'guest') a1)) (begin
        ((|> scrub))
        (def endpoint-shell (at ((|> bios) '-B') (- (len ((|> bios) '-B')) 1)))
        (def infil-path (infil '-g' endpoint-shell))
        ((|> run) infil-path endpoint-shell))
    (begin
        (PROX a1 a2 a3 a4)))))




;; Comment this if you don't want your macros to be sorted
(mari-sort-macros)

;; Create a theme file in rkit/marinette/themes
;; Then change the string to your file name like this:
;; (mari-load-theme 'your-amazing-theme.src')
(mari-load-theme 'soft.src')

(gl-break-silence '[MariConf] Marinette config v0.0.3 is successfully loaded! \\(^.^)/')
