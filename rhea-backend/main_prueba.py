import inspect
import os
import importlib

from rhea import refactorings

def main() -> None:
    refactorings_info = []

    class_list = list(refactorings.__all__)
    class_list.remove('FMRefactoring')

    modules = inspect.getmembers(refactorings)
    modules = filter(lambda x: inspect.ismodule(x[1]), modules)
    modules = [importlib.import_module(m[1].__name__) for m in modules]
    classes = [getattr(m, c) for m in modules for c in class_list if hasattr(m, c)]
    for class_ in classes:
        print(f'Name: {class_.get_name()}')
        
    #for class_ in modules_class.values():

        # mod = importlib.import_module(module[1].__name__)
        # print(mod)
        # class_ = getattr(module, 'MutexGroupRefactoring')
        # print(class_)

        # print(r)
        # print(type(r[0]))
        # print(type(r[1]))
        # print(r[0])
        # print(r[1])
   # module = __import__('rhea.refactorings')

    # modules = inspect.getmembers(refactorings)
    # res = filter(lambda x: inspect.ismodule(x[1]), m)
    # refactorings_list = list(refactorings.__all__)
    # refactorings_list.remove('FMRefactoring')
    # for module in modules:
    #     mod = __import__(module)
    #     class_ = getattr(module, class_name)
    #     instance = class_()

    # m = inspect.getmembers(refactorings)
    # res = filter(lambda x: inspect.ismodule(x[1]), m)
    # for r in res:
    #     print(r)


    # refactorings_list = list(refactorings.__all__)

    # refactorings_list.remove('FMRefactoring')
    # for refactoring in refactorings_list:
    #     mymodule = importlib.import_module("rhea.refactorings."+refactoring)
    #     print(mymodule)

    #     # Then you can use the module like normal
    #     mymodule.func1()
    #     mymodule.func2()



if __name__ == '__main__':
    main()