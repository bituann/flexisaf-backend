# flexisaf-backend

This tutorial is purely for the command line interface, and assumes a basic understanding of CLI commands and operations.

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
