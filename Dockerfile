# ALWAYS USE LATEST
FROM gitpod/workspace-full

USER gitpod

# INSTALL LATEST JAVA
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    echo y|sdk upgrade"

# INSTALL LATEST PYTHON
RUN pip install --upgrade pip

# INSTALL COOL STUFF
RUN brew install fzf eza buildpacks/tap/pack kubectl
RUN yes | $(brew --prefix)/opt/fzf/install

# DEFAULT TO ZSH
ENV SHELL=/usr/bin/zsh

RUN git clone https://github.com/zsh-users/zsh-autosuggestions /home/gitpod/.zsh/zsh-autosuggestions
ADD --chown=gitpod:gitpod https://raw.githubusercontent.com/maeddes/dotfiles/main/.zshrc.gitpod.full /home/gitpod/.zshrc
