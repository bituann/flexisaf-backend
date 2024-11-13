# Git and GitHub

This tutorial assumes a basic understanding of CLI commands and operations.
This tutorial uses git on the command line, and GitHub on the web

## Create a Git Repository
  There are two ways in which a repository can be gotten. The first is by creating the repositoty, and the second is by cloning an existing repository. The latter will be explained in the next section. This section focuses on creating a git repository from scratch. 
  1. Create the directory (folder) in your computer, if it doesn't already exist (`mkdir <folder_name>`)
  2. Go to that directory (`cd <directory_path>`)
  3. Initialize git within the directory, using the command `git init`. A .git folder will be created
  4. If the directory was empty, then that's all for creating a git repository
  5. If the directory isn't empty, then:
       - if you want to include all existing files in git's version control, type `git add *`
       - if you only want to include selected files, then type `git add <filename.extension>`. Repeat for all files to be tracked.

At this point, your repository is up and ready to be used by git.

## Cloning a Git Repository
  If there is an already existing repository (most likely, on a remote server somewhere), and you want to make a copy of that repository to your own computer, the command for that is `git clone <url>`. For example, `git clone https://github.com/bituann/flexisaf-backend`

Usually, the repository will be cloned into the current working directory, under the name of the repository (that is, if the name of the repository is "flexisaf-backend", then the repository is cloned into a folder named "flexisaf-backend"). If you don't want it that way, you can indicate the name which you want the folder to be called. The command to do this is `git clone <url> <folder-name>`. For example, the command `git clone https://github.com/bituann/flexisaf-backend myfolder` will clone the repository into a folder called "myfolder", instead of "flexisaf-backend"

## Creating Branches
Branching means diverting from the main development line, meaning whatever changes you make on a branch never affects the main line.
  
To create a branch a Git, the command `get branch <branchname>` is used.

Git does not automatically switch to a branch; the git command above only creates a new branch. To switch to an existing branch, use the command `git checkout <branchname>`. If, however, you want to create a new branch and switch to it at the same time, then the command `git checkout -b <newbranchname>` is to be used.
  
Starting from git 2.23, `git switch` was introduced. It is used instead of `git checkout` in the following ways:
  - `git switch <branchname>` switches to a new branch
  - `git switch -c <newbranchname>` creates an new branch and switches to it
  - `git switch -` switches to the branch checked out previously

It is important to remember that if there are uncommitted changes in your staging area that conflicts with the branch you're switching to, git will not allow you to switch branches 

## Committing Changes
Committing changes to the repository means taking a 'snapshot' of your repository so that git is able to revert back to it if any unwelcome changes were to occur. In orger to commit files (and changes to them) to the repository, a few steps must be taken.
  1. Check to see if there are any files currently tracked. To do this, use `git status`. This command is also used to check if any changes have been made to the files in order to move to the next stage
  2. Next, the files to be committed are to be tracked. Remember how `git status` checks if changes have been made to a file? That's only possible if the files have been tracked. To track a file, use `git add <file name/path>`. If you want to track all the files in the repository, you don't have to run the command for every file; use `git add *` instead. Tracking a file for the first automatically stages it for committing. Only staged files (and changes) can be committed. If a change has been made to a file, use `git add <file name/path>` to stage the file for the next commit. It is important to think of the `git add` command as a "make sure the next commit includes this file or this change in the file"
  3. Finally, run `git commit`. This command will open up an editor where you can include a message to be added to the commit. This message can be a short description of what canges has been made, or what has been added; and it can also be a lengthy explanation of why a change was made. Exit the editor to complete the commit. If you want to skip the editor opening up (perhaps because the commit message is very short), you can use `git commit -m '<message'`. Another useful hack is including the `-a` flag to the commit command (`git commit -a`). This allows you to skip the staging process, and add all files already tracked to the commit

## Reverting Commits

## Pulling and Pushing Changes
Pulling changes (downstream) means getting information from a repository, updating the one that's local to your machine with any available changes. It is done with the command `git pull <repository>`.

Pushing changes means sending your commits and merge history to the remote server where the repository is located. The command for it is `git push <remote url>`.

## Fetching Changes
Fetching changes means viewing your commit history, as this is a record of the changes you've made to the repository since it was first created. This is especially useful if you clone a repository; surely, you'd want to see what had been done so far in that repository. The command for showing all commit changes is `git log`.

`git log` lists all commits made in reverse chronological order (from the latest to the oldest). An important flag that can be added to the `git log` command is `-p`. This shows the exact change made in the files in each commit. `-<number>` is a flag used to show only the specified number of commits

`--pretty=<option>` is also another useful flag. It takes a number of options such as:
  * `oneline`: which displays the commits in one line
  * `short`, `full`, `fuller`: does the same as above but with increasingly more information
  * `format`: allows you to specify a specific format in which its to display the commits. The proper command is `git log --pretty=format:"<specifiers>"`. Some specifiers include:
    * `%an`: authors's name
    * `%cn`: committer's name
    * `%s`: subject

## Merging Branches
To merge a branch with another, you should switch to the main line, then run the command `git merge <branchname>`

After merging a branch with the main line, chances are you no longer need that branch. To delete the branch, use the `-d` flag on the branch command, that is, `git branch -d <branchname>`

If your branch has files that has the same parts altered differently in the two branches you're merging, git won't be able to merge cleanly and you'll encounter a merge error. This means that git has paused the merging until you resolve the conflict. To view the affected files, use `git status`.

You would have to bring the files into agreement by choosing which change stays. In other words, edit the changes in the files to bring them into harmony with each other. Then, add each file to the staging area (`git add <file name/path>`); git marks the conflict as resolved when you do that. After staging, run `git commit` to finalize the merging process that was paused.

## Renaming Branches
Assuming you made a mistake while naming a branch — it could be a typo, a miscommunication — you'd definitely appreciate a way to fix that mistake. Fortunately, git comes with a command for renaming branches. The command is `git branch --move <oldbranchname> <newbranchname>`.

The command above renames the branch locally, but if the branch also exists on a server elsewhere (which, it most likely does), then you'd need a two sets of commands to change the version on the server. The commands are:
  - `git push --set-upstream origin newbranchname`, followed by
  - `git push origin --delete oldbranchname`

## Creating Pull Requests
Pull requests are made when you want to work on a project that isn't yours, or a repository that you don't have write permissions for. It's a request made for the owner of the repository, or a contributor to merge your branch with the main branch. If you don't have write permission, the owner will first pull your branch into the repository(if you don't have write permission), before merging it with the main branch.

If you have write permission, pull requests can be made on github through the following steps:
* Go to the main repository page
* Switch to the branch that contains your commits
* Click on the "Pull request" tab
* Click on "New Pull Request"
* Set "base branch" to the branch you want your changes to be merged into
* Set "compare branch" to the branch that contains your changes
* Type a title and description for the pull request
* Click "Create Pull Request"

If you don't have write permission, then you'd have to make a fork of the repository (a copy of that repository but with full control given to you). After that, make your changes, commit them, push to the repository on GitHub, then proceed with the following steps:

* Go to the main repository page
* Click on the "Pull request" tab
* Click on "New Pull Request"
* On the page that appears, click "Compare across fork"
* Set "base branch" to the repository you want to merge into
* Set "head fork" to the your forked repository (and the branch) in which you made the changes
* Type in a title and description for the pull request
* Click "Create Pull Request"

## Reviewing and Merging Pull Requests

## Reverting Pull Request
Reverting a pull request creates a pull request which will undo the merge commit of the original pull request. If you want to revert a pull, request for whatever reason, then follow the steps outlined. It is important to state that you need write permission on the repository before you can revert a pull request. If you don't have such permission, you'd need to ask the repository administrator for write permmision. With that out of the way, the steps are:
* In the main repository, click on "Pull Requests" tab
* Select the pull request you'd like to revert from the list it presents
* Click "Revert", which can be found near the bottom of the pull request
* Merge the resulting pull request
