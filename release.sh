#git clone -o calculator_r2 https://github.com/Kovalsky95/calculator_r2.git
#git config --global credential.helper cache
git config --global credential.helper "cache --timeout=3600"
#git config credential.helper store
#git config --unset credential.helper
git pull --all
git add .
git commit -m PenguinL
git push --set-upstream calculator_r2 master