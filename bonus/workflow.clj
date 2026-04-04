;; A script to open everything up for a hacking session!

(def silent-state (: SILENT))
(:= SILENT 2)

((|> unlock) 'y')

(def deletion-queue (array '^guest$' '^Downloads$' '^Desktop$' '^.Trash$'))
(foreach _ re deletion-queue (begin
    (def files ((|> grep) '-a' re))
    (if (== 'list' (typeof files))
        (foreach _ file files (begin
            (def path ((|> file) '-p' file))
            (if (== 'Desktop' ((|> file) '-n' file)) (begin
                (def parent ((|> file) '-P' file))
                ((|> del) path)
                ((|> mkdir) (gl-pathcat (array ((|> file) '-p' parent) 'Desktop')))
                ((|> mkdir) (gl-pathcat (array path '.a')))
                ((|> del) (gl-pathcat (array path '.a'))))
            (begin
                ((|> del) path))))))))

((|> run) '/usr/bin/FileExplorer.exe')

((|> pause) '2')
((|> run) '/usr/bin/Mail.exe')

((|> kore) '-sc')
((|> macro) 'unlock' 'y')

(:= SILENT silent-state)
