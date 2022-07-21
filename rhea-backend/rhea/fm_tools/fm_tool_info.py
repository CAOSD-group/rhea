from abc import ABC, abstractmethod

from rhea.fm_concepts import FMConcept


class FMToolInfo():

    def __init__(self, name: str, support: set[FMConcept]) -> None:
        self._name = name 
        self._support = support

    @property
    def name(self) -> str:
        return self._name

    @property
    def support(self) -> set[FMConcept]:
        return self._support
