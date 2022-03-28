import os
import subprocess


METAMODELS_DIR = os.path.join('rhea', 'metamodels')
METAMODELS_CODE_DIR = os.path.join('rhea', 'fms')


def get_metamodels() -> dict[str, str]:
    """Return a dictionary of metamodels NAME -> filepath."""
    metamodels = {}
    for subdir, dirs, files in os.walk(METAMODELS_DIR):
        for file in files:
            metamodels[os.path.splitext(file)[0]] = os.path.join(subdir, file)
    return metamodels


def generate_metamodels_code(metamodels: dict[str, str]) -> None:
    for metamodel in metamodels.values():
        print(f'Generating code for metamodel {metamodel}.')
        subprocess.run(['pyecoregen', '-e', metamodel, '-o', METAMODELS_CODE_DIR], capture_output=True)


def fix_metamodels_imports(metamodels: dict[str, str]) -> None:
    for subdir, dirs, files in os.walk(METAMODELS_CODE_DIR):
        for file in files:
            filepath = os.path.join(subdir, file)
            with open(filepath, 'r+') as f:
                content = f.read()
                for mm in metamodels.keys():
                    content = content.replace(f'from {mm} import', f'from rhea.fms.{mm} import')
                f.seek(0)
                f.truncate()
                f.write(content)

if __name__ == '__main__':
    print('Getting all metamodels...')
    metamodels = get_metamodels()
    print('Generating code from metamodels...')
    generate_metamodels_code(metamodels)
    print('Fixing metamodels imports...')
    fix_metamodels_imports(metamodels)
    print('Done.')