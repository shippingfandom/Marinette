;; 
;; Marinette library
;;

;; Load custom theme
(defun mari-load-theme (theme) (begin
    (def grep (gl-grep-into (array '^rkit$' '^marinette$' theme)))
    (if grep (begin
        (def content (trim ((_ grep get_content) grep)))
        (def lines (split content (char 10)))
        (if content
            (foreach _ line lines (begin
                (def parts (split line ' '))
                (def color-name (at parts 0))
                (def color-value (at parts 2))
                (set globals color-name ((_ color-value replace) color-value (char 34) ''))
                (:= colorDefault ((_ (: colorGreen) replace) (: colorGreen) '<b>' ''))))
            (gl-break-silence (join (array '[Mari] Could not load ' theme ' theme!') ''))))
        (gl-break-silence (join (array '[Mari] Could not load ' theme ' theme!') '')))))

;; Populate rkit/marinette w/ a directory
(defun mari-mkdir (dirname) (begin
    (def marinette (gl-grep-into (array '^rkit$' '^marinette$')))
    (if marinette
        ((|> mkdir) (gl-pathcat (array ((_ marinette path) marinette) dirname))))))

;; Return args from macros @pipe
(defun mari-args () (begin
    (def args (@ PIPE))
    (@= PIPE '')
    (if (== (typeof args) 'string')
        (split args ' ')
        (array ''))))

;; Return arg, parsed, from macros @pipe[idx]
(defun # (args idx fallback) (begin
    (if (hasIndex args idx)
        (if (at args idx)
            (at args idx)
            fallback)
        fallback)))

;; Sets 5hell macro
(defmacro >> (macroname args macrobody) () (begin
    (defun macroname () (begin
        (def args (mari-args))
        macrobody))
    ((|> macro) '-s' (quote macroname) (join (array 'glosure -e \" (:= SILENT 2) \" | | cob set PIPE \@pipe | | glosure -e \" (:= SILENT 0) \" | | glosure -e (' (quote macroname) ')') ''))))

;; Sorts 5hell macros
(defun mari-sort-macros () (begin
    (def macros (@ macros))
    (def keys (indexes macros))
    (def sorted (dict))
    (sort keys)
    (foreach _ key keys (begin
        (set sorted key (at macros key))))
    (@= macros sorted)))

;; Creates hidden directory with random name
(defun mari-mkdir-hidden-infil (computer) (begin
    (def root ((_ computer File) computer '/'))
    (def folders ((_ root get_folders) root))
    (def return null)
    (while folders (begin
        (def folder (pull folders))
        (def folder-name (+ '.' (gl-random-string 5)))
        (if (== 1 ((_ computer create_folder) computer ((_ folder path) folder) folder-name)) (begin
            (def folders (array))
            (def return ((_ computer File) computer (gl-pathcat (array ((_ folder path) folder) folder-name)))))
        (begin
            (def folders (+ folders ((_ folder get_folders) folder)))))))
    return))

;; Get a debug library from the top of the BUFFER
(defun mari-buffer-top-debug-library () (begin
    (def return null)
    (def buffer (+ (array) ((|> bios) '-B')))
    (while (> (len buffer) 0) (begin
        (def potential-debug-library (pop buffer))
        (if (== 'debugLibrary' (typeof potential-debug-library)) (begin
            (def buffer (array))
            (def return potential-debug-library)))))
    return))




;; Init
(gl-break-silence '[Mari] Marinette v0.0.2 is successfully loaded! \\(^.^)/')
