### Git Guide
* This guide aims to help new users to Git and,
* an archive of some key commands that may be useful

`git status` shows you which files are in this staging area, and which files have changes that haven't yet been put there. In order to compare the file as it currently is to what you last saved, you can use `git diff` filename. `git diff` without any filenames will show you all the changes in your repository, while `git diff [directory]` will show you the changes to the files in some directory.

use `git log` to check all commits
```bash
git annotate [filename]
```

The command git `clean -n` will show you a list of files that are in the repository, but whose history Git is not currently tracking. A similar command `git clean -f` will then delete those files.

```bash
git config --list [--local | --global | --system]
```

to change email or username
```bash
git config --global user.email someemail@mail.com
git config --global user.name username
```

to undo changes to unstaged files
```bash
git checkout -- path/filename 
```

to undo changes to staged files
```bash
git reset filename
```

to restore to a particular version
```bash
git checkout hash(sha1) path/filename
```

use . to represent all files in the current directory

to check for differnces in commits also differences in branches
```bash
git diff 
```

to change branch
```bash
git checkout branchname
```

to create new branch and switch to it
```bash 
git checkout -b branchname
```

Merging Branches
```bash
git merge source destination
```

if conflict
use `git status` to see which files conflict
resolve conflict - can use nano or any editor
```bash
git add file
git commit -m "some msg"
```

to create new repo
```bash
git init repo name
```

Experienced Git users instinctively start new projects by creating repositories. If you are new to Git, though, or working with people who are, you will often want to convert existing projects into repositories. Doing so is simple, just run:

```bash
git init 		# in the project's root directory
```

```bash
git init /path/to/project 		# from anywhere else on your computer
```

to add a remote
```bash
git remote add remote-name URL
```

if there are conflicts
```bash
git pull --no-edit origin master
```